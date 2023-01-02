package it.jdk.wiki.actions;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import it.jdk.wiki.controller.MyWikiException;
import javax.naming.NamingException;

public class PulsantieraAction implements Action{
	
	private final static String PRINCIPALE ="principale";
	private final static String RECENTI = "recenti";
	private final static String TUTTE = "tutte";
	private final static String EMAIL = "email";

	@Override
	public ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException {
		if(requestObject.getValue(PRINCIPALE)!=null) {
			requestObject.setValue("titolo",null);
			try {
				return new VediPaginaAction().createResponseAndView(requestObject);
			}
			catch(NamingException e) {
				throw new MyWikiException(e);
			}
		}
		if(requestObject.getValue(TUTTE)!=null) {
			requestObject.setValue("tipo_richiesta", "tutte");
			try {
				return new ListaPagineAction().createResponseAndView(requestObject);
			}
			catch(NamingException e) {
				throw new MyWikiException(e);
			}
		}
		if(requestObject.getValue(RECENTI)!=null) {
			requestObject.setValue("tipo_richiesta", "recenti");
			try {
				return new ListaPagineAction().createResponseAndView(requestObject);
			}
			catch(NamingException e) {
				throw new MyWikiException(e);
			}
		}
		if(requestObject.getValue(EMAIL)!=null) {
			ResponseObject responseObject = new ResponseObject();
			responseObject.setValue("titolo", requestObject.getValue("titolo"));
			return new ResponseAndView("email",responseObject);
		}
		
		throw new MyWikiException("Action non riconosciuta");
	}

}
