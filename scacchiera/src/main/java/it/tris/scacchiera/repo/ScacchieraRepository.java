package it.tris.scacchiera.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tris.scacchiera.entities.Scacchiera;

@Repository
public interface ScacchieraRepository extends JpaRepository<Scacchiera,Integer>{

	
	Scacchiera findByPartitaId(Integer id);
}
