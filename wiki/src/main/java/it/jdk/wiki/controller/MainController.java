package it.jdk.wiki.controller;

import it.jdk.wiki.actions.Action;
import it.jdk.wiki.context.ContextObjectFactory;
import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MainController extends HttpServlet{
	
	protected void doGet(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		handleRequest(httpRequest,httpResponse);
	}
	
	protected void doPost(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		handleRequest(httpRequest,httpResponse);
	}

	protected void handleRequest(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException,IOException{
		RequestObject request = ContextObjectFactory.getRequestObject(httpRequest);
		
		try {
			Action action = ActionFactory.createAction(request);
			ResponseAndView response = action.createResponseAndView(request);
			dispatchView(httpRequest,httpResponse,response);
		}
		catch(MyWikiException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void dispatchView(HttpServletRequest httpRequest,HttpServletResponse httpResponse, ResponseAndView response)throws ServletException,IOException,MyWikiException{
		String view = response.getView();
		String resultPage = Configuration.getViewPage(view);
		if(resultPage==null) {
			throw new MyWikiException("Pagina non presente");
		}
		ViewDispatcher dispatcher = new ViewDispatcher(httpRequest.getRequestDispatcher(resultPage));
		dispatcher.forward(httpRequest, httpResponse, response);
	}
	
	public void init(ServletConfig config)throws ServletException {
		Configuration.init(config);
	}
}
