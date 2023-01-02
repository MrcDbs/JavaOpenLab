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


public class EliminaPaginaAction implements Action{

	private PaginaDao paginaDao;
	
    public EliminaPaginaAction() throws NamingException {
        paginaDao = new PaginaDaoImpl();
    }

    @Override
    public ResponseAndView createResponseAndView(RequestObject requestObject) throws MyWikiException {
        ResponseObject responseObject = new ResponseObject();
        String titolo = (String) requestObject.getValue("titolo");
        String tipoRichiesta = (String) requestObject.getValue("tipo_richiesta");

        Pagina pagina = new Pagina();
        pagina.setTitolo(titolo);
        paginaDao.elimina(pagina);
        List<Pagina> lista = null;
        if(tipoRichiesta.equals("tutte")) {
            lista = paginaDao.elencaPagine();
        } else {
            lista = paginaDao.elencaPagineRecenti();
        }
        responseObject.setValue("intestazione", "Ultime pagine modificate");
        responseObject.setValue("lista", lista);
        responseObject.setValue("tipo_richiesta", tipoRichiesta);
        return new ResponseAndView("list",responseObject);
    }
}
