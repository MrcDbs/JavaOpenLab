package it.simpleservlet.controller;

import java.io.IOException;

import it.simpleservlet.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainServlet extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		if(request.getAttribute("risposta").equals("ACCESSO EFFETTUATO")) {
			User user1 = new User();
			HttpSession session = request.getSession();
			user1.setPassword(request.getParameter("password"));
			user1.setUsername(request.getParameter("username"));
			
			session.setAttribute("user1", user1);
			request.getRequestDispatcher("WEB-INF/views/output.jsp").forward(request, response);
		}
//		else {
//			
//			request.getRequestDispatcher("accessoNegato.html").forward(request, response);
//		}
	}
}
