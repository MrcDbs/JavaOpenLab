package it.jdk.wiki.actions;

import javax.naming.NamingException;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.dao.PaginaDao;
import it.jdk.wiki.dao.PaginaDaoImpl;
import it.jdk.wiki.model.Pagina;

public class ModificaPaginaAction implements Action{
	
	private PaginaDao paginaDao;
	
	public ModificaPaginaAction()throws NamingException{
		paginaDao = new PaginaDaoImpl();
	}

	@Override
	public ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException {
		ResponseObject response = new ResponseObject();
		String titolo = (String) requestObject.getValue("titolo");
		response.setValue("titolo", titolo);
		String body = null;
		try {
			Pagina pagina = paginaDao.leggi(titolo);
			body = pagina.getContenuto();
		}
		catch(MyWikiException e) {
			body = "";
		}
		response.setValue("contenuto", body);
		return new ResponseAndView("edit",response);
	}

}
