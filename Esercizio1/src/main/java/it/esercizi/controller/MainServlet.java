package it.esercizi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.esercizi.javaBean.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{

	protected void doPost(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		Persona persona = new Persona();
		persona.setNome(httpRequest.getParameter("nome"));
		persona.setCognome(httpRequest.getParameter("cognome"));
		persona.setCodiceFiscale(httpRequest.getParameter("codiceFiscale"));
		persona.setCittà(httpRequest.getParameter("citta"));
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(httpRequest.getParameter("data"));
		} catch (ParseException e) {
			httpRequest.setAttribute("error",httpRequest.getParameter("data"));
			e.printStackTrace();
		}
		persona.setDataDiNascita(date1);
		persona.setUsername(httpRequest.getParameter("username"));
		persona.setPassword(httpRequest.getParameter("password"));
		persona.setGenere(httpRequest.getParameter("genere").charAt(0));
		//String[] lista = (String[])httpRequest.getParameterValues("newsletter");
		persona.setNewsletterList(httpRequest.getParameterValues("newsletter"));
		
		httpRequest.setAttribute("persona", persona);
		httpRequest.getRequestDispatcher("WEB-INF/views/resultUseBean.jsp").forward(httpRequest,httpResponse);
	}
}

