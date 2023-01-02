package it.articoli.repo;

import java.util.List;



public interface ArticoloCustomRepo<T> {

	public T readWithCriteriaByTitolo(String filtro);
	
	
}
