package it.jdk.wiki.context;

import java.util.Enumeration;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class ContextObjectFactory {

	public static RequestObject getRequestObject(HttpServletRequest httpRequest) {
		RequestObject request = new RequestObject();
		String path = httpRequest.getServletPath().split(".action")[0];
		if(path.startsWith("/")) {
			path = path.substring(1);
		}
		request.setRequestComand(path);
		Map<String,String[]> parameters = httpRequest.getParameterMap();
		for(String key:parameters.keySet()) {
			request.setValue(key, parameters.get(key));
		}
		Enumeration<String> sessionValues = httpRequest.getSession().getAttributeNames();
		while(sessionValues.hasMoreElements()) {
			String key = sessionValues.nextElement();
			request.setValueInSession(key, httpRequest.getSession().getAttribute(key));
		}
		return request;
	}
}
