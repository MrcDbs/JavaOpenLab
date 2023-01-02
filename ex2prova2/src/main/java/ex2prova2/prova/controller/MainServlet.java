package ex2prova2.prova.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/miaservlet")
public class MainServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String str = request.getParameter("param1");
		
		request.getSession().setAttribute("param1",str);
		
		request.getRequestDispatcher("URL/path").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String str = request.getParameter("param1");
		
		request.setAttribute("param1",str);
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	
	public void init() {}
	
	public void destroy() {}

}
