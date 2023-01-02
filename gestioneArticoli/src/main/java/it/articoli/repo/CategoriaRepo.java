package it.articoli.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.articoli.composite.CategoriaNome;
import it.articoli.entities.Categoria;

public interface CategoriaRepo  extends JpaRepository<Categoria, CategoriaNome>{
	
	Categoria findByNomeNome(String nome);
	
	Page<Categoria> findAll(Pageable pageable);
	
	

}
