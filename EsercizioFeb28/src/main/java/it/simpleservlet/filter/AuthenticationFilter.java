package it.simpleservlet.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter{

	  public void init(FilterConfig config) throws ServletException {
	    }

	    public void doFilter(ServletRequest request, ServletResponse response,
	                         FilterChain chain) throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        String hidden = httpRequest.getParameter("richiesta");
	        if(hidden!=null && hidden.equals("auth")) {
		        String secure = httpRequest.getParameter("password");
		        String user = httpRequest.getParameter("username");
		        if (secure.equals("102938") && user.equals("Rossimario9")) {
		            httpRequest.setAttribute("password", secure);
		            httpRequest.setAttribute("username", user);
		            httpRequest.setAttribute("risposta", "ACCESSO EFFETTUATO");
		            chain.doFilter(httpRequest, response);
		        }
		        else {
//		        	httpRequest.setAttribute("risposta", "ACCESSO NEGATO");
//		        	 chain.doFilter(httpRequest, response);
		        	HttpServletResponse httpResponse = (HttpServletResponse) response;
		        	httpResponse.sendRedirect("accessoNegato.html");
		        }
	        }
	        else {
	        	HttpServletResponse httpResponse = (HttpServletResponse) response;
	        	httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        }
	      
	        
	    }

	    public void destroy() {
	    }
}
