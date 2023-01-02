package it.articoli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.articoli.dto.CategoriaDTO;
import it.articoli.entities.Categoria;
import it.articoli.repo.CategoriaRepo;

@Service
public class CategoriaService {

	private final CategoriaRepo categoriaRepo;
	
	@Autowired
	public CategoriaService( CategoriaRepo categoriaRepo) {
		this.categoriaRepo=categoriaRepo;
	}
	
	public void createCategoria(CategoriaDTO categoria) {
		Categoria c = new Categoria();
		c.setDescrizione(categoria.getDescrizione());
		c.setNome(null);
	}
}
