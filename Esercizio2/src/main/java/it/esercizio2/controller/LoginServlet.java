package it.esercizio2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import it.esercizio2.javabean.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		Utente utente = new Utente(httpRequest.getParameter("username"),httpRequest.getParameter("password"));
		
		httpRequest.getSession().setAttribute("utente", utente);
		
		httpRequest.setAttribute("utente", utente);
		
		httpRequest.getRequestDispatcher("WEB-INF/views/result.jsp").forward(httpRequest, httpResponse);
	}
	
	protected void doGet(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		 //String testo = (String) httpRequest.getSession().getAttribute("testo");
		 String testo = (String)httpRequest.getAttribute("testo");
		httpResponse.setContentType("text/html");
		PrintWriter out = httpResponse.getWriter();
		 out.write("<HTML><HEAD><TITLE>Result</TITLE></HEAD><BODY>");
	        out.write("<H1>This is the text you entered</H1>");
	        
	        
	        out.write("<BR />"+testo+"</B>");
	        

	        out.write("</BODY></HTML>");
	        out.flush();
	}
}
