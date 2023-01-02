package it.tris.scacchiera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.tris.scacchiera.dto.UtenteDTO;
import it.tris.scacchiera.entities.Utente;
import it.tris.scacchiera.repo.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepo;

	@Transactional
	public UtenteDTO registraUtente(UtenteDTO utenteDto) {
		Utente u1 = new Utente();
		u1.setNome(utenteDto.getNome());
		u1.setCognome(utenteDto.getCognome());
		Integer id = utenteRepo.save(u1).getId();
		System.out.println(" ** ID DI UTENTE "+id);
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setNome(u1.getNome());
		utenteDTO.setCognome(u1.getCognome());
		utenteDTO.setId(id);
		return utenteDTO;
	}
}
