package it.auto.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.auto.dto.AutoDTO;
import it.auto.entities.Auto;

public interface AutoRepo extends JpaRepository<Auto,Integer>{
	
	@Query("select new it.auto.dto.AutoDTO(a.targa,a.modello,a.dataProduzione,a.costo) from Auto a where a.id=:id")
	public AutoDTO readById(Integer id);

	@Query("select new it.auto.dto.AutoDTO(a.targa,a.modello,a.dataProduzione,a.costo) from Auto a where a.targa=:targa")
	public AutoDTO readByTarga(String targa);
	
	@Query("select new it.auto.dto.AutoDTO(a.targa,a.modello,a.dataProduzione,a.costo) from Auto a where a.modello=:modello")
	public List<AutoDTO> readByModello(String modello);
	
	public Page<Auto> findAll(Pageable pageable);
}
