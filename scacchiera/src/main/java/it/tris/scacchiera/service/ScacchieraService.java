package it.tris.scacchiera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.tris.scacchiera.dto.ScacchieraDTO;
import it.tris.scacchiera.entities.Partita;
import it.tris.scacchiera.entities.Scacchiera;
import it.tris.scacchiera.entities.Utente;
import it.tris.scacchiera.repo.PartitaRepository;
import it.tris.scacchiera.repo.ScacchieraRepository;
import it.tris.scacchiera.repo.UtenteRepository;
import it.tris.scacchiera.utils.TrisUtils;

@Service
public class ScacchieraService {
	
	

	@Autowired
	private ScacchieraRepository scacchieraRepo;
	
	@Autowired
	private PartitaRepository partitaRepo;

	@Autowired
	private UtenteRepository utenteRepo;
	
	@Transactional
	public ScacchieraDTO creaScacchiera(Integer idUtente,Integer idPartita) {
		Utente u1 = utenteRepo.findById(idUtente).get();
		Partita p1 = partitaRepo.findById(idPartita).get();
		Scacchiera sc1 = new Scacchiera();
		sc1.setPartita(p1);
		sc1.setUtenteTurno(u1);
		scacchieraRepo.save(sc1);
		
		ScacchieraDTO scDto = new ScacchieraDTO();
		scDto.setUtenteInTurno(u1.getNome()+" "+u1.getCognome());
		scDto.setStatoPartita("In corso");		
		return scDto;
	}
}
