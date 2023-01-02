package it.articoli.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.articoli.entities.Sezione;

public interface SezioneRepo extends JpaRepository<Sezione, Integer>{

	Page<Sezione> findAll(Pageable pageable);
}
