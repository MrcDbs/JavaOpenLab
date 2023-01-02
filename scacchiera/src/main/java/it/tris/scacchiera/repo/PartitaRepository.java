package it.tris.scacchiera.repo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.tris.scacchiera.dto.PartitaDTO;
import it.tris.scacchiera.entities.Partita;
import it.tris.scacchiera.entities.Utente;

@Repository
public interface PartitaRepository extends JpaRepository<Partita, Integer> {

	@Transactional
	@Query("select new it.tris.scacchiera.dto.PartitaDTO(p.giocatore1.nome,p.giocatore2.nome,p.id)from Partita p where p.giocatore1.id=:id or p.giocatore2.id=:id")
	public List<PartitaDTO> findPartiteByGiocatore(@Param("id") Integer id);
	
	@Query("select p.giocatore1 from Partita p where p.id=:idP")
	public Utente getGiocatore1(Integer idP);

	@Query("select p.giocatore2 from Partita p where p.id=:idP")
	public Utente getGiocatore2(Integer idP);
	
	
}
