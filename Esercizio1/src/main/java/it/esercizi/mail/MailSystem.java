package it.esercizi.mail;

import it.esercizi.controller.EmailException;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSystem {
//    public static void main(String[] args){
//        MailSystem mail = new MailSystem();
//        try {
//            mail.sendMail("a.zoia@jdk.it","a.zoia@jdk.it", "mail.jdk.it",
//                    "INOMAnIMplad","20000","", new Pagina(),"false","true");
//        } catch (MyWikiException e) {
//            e.printStackTrace();
//        }
//    }

    public void sendMail(final String mittente, String destinatario, String host,
                        final String password, String commento, String port,  String ssl,String at) throws EmailException {

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", ssl);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", mittente);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", at);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mittente, password);
                    }
                });
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(mittente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

//            message.setSubject(pagina.getTitolo());
//            message.setText(pagina.getContenuto() + "\n\n\n" + "Commento:\n\n"+commento);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, mittente, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException e) {
            throw new EmailException(e);
        } catch (MessagingException me) {
            throw new EmailException(me);
        }
    }
}


