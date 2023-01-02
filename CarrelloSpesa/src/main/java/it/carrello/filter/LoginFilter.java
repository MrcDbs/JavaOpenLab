package it.carrello.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	  public void init(FilterConfig config) throws ServletException {
	    }

	    public void doFilter(ServletRequest request, ServletResponse response,
	                         FilterChain chain) throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        
	        if(httpRequest.getParameter("richiesta").equals("auth")) {
		        String secure = httpRequest.getParameter("password");
		        String user = httpRequest.getParameter("username");
		        if (secure != null && secure.equals("102938") && user.equals("Rossimario9")) {
		            httpRequest.setAttribute("password", secure);
		            chain.doFilter(httpRequest, response);
		        }
	        }
	        if(!httpRequest.getParameter("richiesta").equals("auth")) {
	        	chain.doFilter(httpRequest, response);
	        }
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        
	    }

	    public void destroy() {
	    }
}
