package it.tris.scacchiera.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tris.scacchiera.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {

}
