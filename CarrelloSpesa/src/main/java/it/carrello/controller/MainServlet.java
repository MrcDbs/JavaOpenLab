package it.carrello.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.carrello.javabean.Carrello;
import it.carrello.javabean.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		if(request.getParameter("richiesta").equals("auth")) {
//		    HttpSession session = request.getSession();
			
//			Carrello carrello = new Carrello();
//			session.setAttribute("carrello", carrello);
			request.getRequestDispatcher("WEB-INF/views/carrello.jsp").forward(request, response);
		}
		if(request.getParameter("richiesta").equals("carrello")) {
			List<Item> lista = new ArrayList<Item>();
			HttpSession session = request.getSession();
			for(String s:request.getParameterValues("items")) {
				lista.add(new Item(1L,Double.parseDouble(s.split("-")[1]),s.split("-")[0]));
			}
			Carrello carrello = new Carrello();//(Carrello) session.getAttribute("carrello");
			carrello.setLista(lista);
			session.setAttribute("carrello", carrello);
			request.getRequestDispatcher("WEB-INF/views/result.jsp").forward(request, response);
//			String[] listaDescr  = request.getParameterValues("items");

		
			//List<Item> listaItems = session.getAttribute("carrello");
		}
		if(request.getParameter("richiesta").equals("checkout")) {
			HttpSession session = request.getSession();
			Carrello carrello =(Carrello) session.getAttribute("carrello");
			request.setAttribute("tot",carrello.getTot());
			session.invalidate();
			request.getRequestDispatcher("WEB-INF/views/ultima.jsp").forward(request, response);
		}
		
	}

}
