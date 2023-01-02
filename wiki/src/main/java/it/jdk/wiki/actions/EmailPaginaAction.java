package it.jdk.wiki.actions;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import it.jdk.wiki.controller.Configuration;
import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.dao.PaginaDao;
import it.jdk.wiki.dao.PaginaDaoImpl;
import it.jdk.wiki.mail.MailSystem;
import it.jdk.wiki.model.Pagina;
import it.jdk.wiki.utils.TextConverter;

import javax.naming.NamingException;

public class EmailPaginaAction implements Action {

    private PaginaDao paginaDao;

    public EmailPaginaAction() throws NamingException {
       paginaDao = new PaginaDaoImpl();
    }

    @Override
    public ResponseAndView createResponseAndView(RequestObject requestObject) {
        ResponseObject responseObject = new ResponseObject();
        String titolo = (String) requestObject.getValue("titolo");
        String destinatario = (String) requestObject.getValue("destinatario");
        String commento = (String) requestObject.getValue("commento");
        Pagina pagina = null;
        try {
          pagina = paginaDao.leggi(titolo);
          MailSystem mailSystem = new MailSystem();
          mailSystem.sendMail(Configuration.getMailValue("mail.smtp.user"),
                              destinatario,
                              Configuration.getMailValue("mail.smtp.host"),
                              Configuration.getMailValue("mail.smtp.password"),
                              commento,
                              Configuration.getMailValue("mail.smtp.port"),
                              pagina,
                              Configuration.getMailValue("mail.smtp.starttls.enable"),
                              Configuration.getMailValue("mail.smtp.auth"));
        } catch (MyWikiException e) {
           throw new RuntimeException(e);
        }

        responseObject.setValue("titolo",titolo);
        responseObject.setValue("contenuto", pagina.getContenuto());
        responseObject.setValue("mail_ok", "Mail inviata con successo");
        return new ResponseAndView("main",responseObject);
    }

}
