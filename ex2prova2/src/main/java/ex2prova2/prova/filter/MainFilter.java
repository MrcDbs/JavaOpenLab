package ex2prova2.prova.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainFilter implements Filter{

	   public void init(FilterConfig config) throws ServletException {}
	    

	    public void doFilter(ServletRequest request, ServletResponse response,
	                         FilterChain chain) throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        String parametro = httpRequest.getParameter("param1");
	        if (parametro.equals("MarioRossi")) {
	            httpRequest.setAttribute("param1", parametro);
	            chain.doFilter(httpRequest, response);
	        }
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        
	    }

	    public void destroy() {}
	    

}
