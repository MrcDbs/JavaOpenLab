package it.jdk.wiki.actions;

import it.jdk.wiki.context.RequestObject;
import it.jdk.wiki.context.ResponseAndView;
import it.jdk.wiki.context.ResponseObject;
import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.dao.PaginaDao;
import it.jdk.wiki.dao.PaginaDaoImpl;
import it.jdk.wiki.model.Pagina;
import javax.naming.NamingException;
import java.util.List;

public class ListaPagineAction implements Action{
	
	private PaginaDao paginaDao;
	
	
	public ListaPagineAction()throws NamingException{
		paginaDao = new PaginaDaoImpl();
	}

	@Override
	public ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException {
		ResponseObject response = new ResponseObject();
		String tipoRichiesta = (String) requestObject.getValue("tipo_richiesta");
		List<Pagina> lista = null;
		
		if(tipoRichiesta.equals("tutte")) {
			lista = paginaDao.elencaPagine();
			response.setValue("intestazione", "tutte le pagine");
			response.setValue("lista", lista);
		}
		else {
			lista = paginaDao.elencaPagineRecenti();
			response.setValue("intestazione", "ultime pagine modificati");
			response.setValue("lista", lista);
		}
		response.setValue("tipo_richiesta", tipoRichiesta);
		return new ResponseAndView("list",response);
	}

}
