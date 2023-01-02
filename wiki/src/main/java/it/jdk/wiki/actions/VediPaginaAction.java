package it.jdk.wiki.actions;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.dao.PaginaDao;
import it.jdk.wiki.dao.PaginaDaoImpl;
import it.jdk.wiki.utils.TextConverter;
import javax.naming.NamingException;

public class VediPaginaAction implements Action{

	private PaginaDao paginaDao;
	
	public VediPaginaAction()throws NamingException{
		paginaDao = new PaginaDaoImpl();
	}

	@Override
	public ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException {
		ResponseObject responseObject = new ResponseObject();
		String titolo = (String) requestObject.getValue("titolo");
		String body = null;
		if(titolo==null) {
			titolo = "PaginaPrincipale";
		}
		try {
			body = paginaDao.leggi(titolo).getContenuto();
		}
		catch(MyWikiException e) {
			body = "Pagina principale non ancora editata, premi modifica per iniziare";
		}
		body = TextConverter.convert(body);
		
		responseObject.setValue("titolo", titolo);
		responseObject.setValue("contenuto", body);
		return new ResponseAndView("main",responseObject);
	}
}
