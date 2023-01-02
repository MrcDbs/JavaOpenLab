package it.esercizio2.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginFilter1 implements Filter{

	   public void init(FilterConfig config) throws ServletException {
	    }

	    public void doFilter(ServletRequest request, ServletResponse response,
	                         FilterChain chain) throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        String testo = httpRequest.getParameter("testo");
	        
	       // HttpSession session = httpRequest.getSession();
	        //session.setAttribute("testo", httpRequest.getParameter("testo"));
	       // String testo =(String) session.getAttribute("testo");
	       
	        if(testo!=null && testo.equals("start")) {
	        	//session.setAttribute("testo", testo+"+FiltroA");
	        	testo+="+FiltroA";
	        	httpRequest.setAttribute("testo", testo);
	        	chain.doFilter(httpRequest, response);
	        }
	        else {
	        	//session.setAttribute("testo", "FiltroA");
	        	httpRequest.setAttribute("testo","start+FiltroA");
	        	chain.doFilter(httpRequest, response);
	        }
	     
//	      HttpServletResponse httpResponse = (HttpServletResponse) response;
//	      httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	      
	    }

	    public void destroy() {
	    }
}
