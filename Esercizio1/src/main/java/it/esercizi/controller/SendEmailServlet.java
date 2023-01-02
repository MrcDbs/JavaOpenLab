package it.esercizi.controller;

import java.io.IOException;

import it.esercizi.mail.MailSystem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SendEmailServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		String mittente = httpRequest.getParameter("mittente");
		String destinatario = httpRequest.getParameter("destinatario");
		String soggetto = httpRequest.getParameter("soggetto"); 
		String contenuto = httpRequest.getParameter("contenuto");
		String feedback = null;
		MailSystem mail = new MailSystem();
		try {
			mail.sendMail(mittente, destinatario, "smtp-relay.gmail.com ", "*", contenuto, "465","true","true");
			feedback = "Invio riuscito";
	
		} catch (EmailException e) {
			feedback = "Invio fallito";
			e.printStackTrace();
		}
		httpRequest.setAttribute("feedback", feedback);
		httpRequest.getRequestDispatcher("WEB-INF/views/feedback.jsp").forward(httpRequest, httpResponse);
	}
}
