package it.articoli.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.articoli.dto.ArticoloDTO;
import it.articoli.entities.Articolo;
import it.articoli.entities.Categoria;

public interface ArticoliRepo extends JpaRepository<Articolo, Integer>{
	
	
	public Page<Articolo> findAll(Pageable pageable);
	
	public Page<Articolo> findAllByCategoriaNome_Nome(String nomeCategoria,Pageable pageable);

	@Query("select new it.articoli.dto.ArticoloDTO(a.titolo,a.descrizione) from Articolo a where a.id=:id")
	public ArticoloDTO findByArticoloId(Integer id);
	
	
	@Query("select c from Categoria c inner join Articolo a where a.id=:id")
	Categoria findByArticolo(Integer id);
	
}
