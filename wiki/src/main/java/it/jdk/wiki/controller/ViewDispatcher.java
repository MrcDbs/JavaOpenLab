package it.jdk.wiki.controller;

import java.io.IOException;

import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewDispatcher {
	
	protected RequestDispatcher dispatcher;

	public ViewDispatcher(RequestDispatcher requestDispatcher) {
		super();
		dispatcher = requestDispatcher;
	}

	public void forward(HttpServletRequest httpRequest, HttpServletResponse httpResponse,ResponseAndView response) throws ServletException,IOException{
		mergeDataRequest(httpRequest,response.getResponseObject());
		dispatcher.forward(httpRequest, httpResponse);
	}
	
	private void mergeDataRequest(HttpServletRequest httpRequest,ResponseObject responseObject) {
		if(responseObject==null) {
			return;
		}
		for(String key:responseObject.getRequestKeys()) {
			httpRequest.setAttribute(key, responseObject.getValue(key));
		}
		for(String key:responseObject.getSessionKeys()) {
			httpRequest.getSession().setAttribute(key, responseObject.getValue(key));
		}
	}
}
