package it.jdk.wiki.controller;

import it.jdk.wiki.actions.Action;
import java.util.HashMap;
import java.util.Map;

import it.jdk.wiki.context.RequestObject;

public class ActionFactory {

	protected static Map<String,Action> actions = new HashMap<>();
	
	public static Action createAction(RequestObject request) throws MyWikiException{
		Action action = (Action) actions.get(request.getRequestComand());
		if(action==null) {
			String name = Configuration.getAction(request.getRequestComand());
			if(name==null) {
				throw new MyWikiException("La action "+action+"non esiste");
			
		}
			try {
				action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
				actions.put(request.getRequestComand(), action);
			}
			catch(Throwable t) {
				throw new MyWikiException(name, t);
			}
		
	}
		return action;
	}
	
}
