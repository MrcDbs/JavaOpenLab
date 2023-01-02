package it.jdk.wiki.dao;

import java.util.List;
import java.util.MissingFormatWidthException;

import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.model.Pagina;

public interface PaginaDao {

	void salva(Pagina pagina) throws MyWikiException;
	
	void elimina(Pagina pagina) throws MyWikiException;
	
	Pagina leggi(String titolo) throws MyWikiException;
	
	List<Pagina> elencaPagine() throws MyWikiException;
	
	List<Pagina> elencaPagineRecenti() throws MyWikiException;
 


}
