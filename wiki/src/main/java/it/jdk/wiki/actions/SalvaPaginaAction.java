package it.jdk.wiki.actions;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.dao.PaginaDao;
import it.jdk.wiki.dao.PaginaDaoImpl;
import it.jdk.wiki.model.Pagina;
import it.jdk.wiki.utils.TextConverter;

import javax.naming.NamingException;
import java.util.Date;

public class SalvaPaginaAction implements Action{

	private PaginaDao paginaDao;
	
	public SalvaPaginaAction() throws NamingException {
		paginaDao = new PaginaDaoImpl();
	}

	@Override
	public ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException {
		ResponseObject responseObject = new ResponseObject();
		
		String contenuto = (String)requestObject.getValue("contenuto");
		String titolo = (String)requestObject.getValue("titolo");
		
		Pagina pagina = new Pagina();
		pagina.setContenuto(contenuto);
		pagina.setTitolo(titolo);
		pagina.setUltimaModifica(new Date());
		paginaDao.salva(pagina);
		
		responseObject.setValue("titolo", titolo);
		responseObject.setValue("contenuto",TextConverter.convert(contenuto));
		return new ResponseAndView("main",responseObject);
	}
}
