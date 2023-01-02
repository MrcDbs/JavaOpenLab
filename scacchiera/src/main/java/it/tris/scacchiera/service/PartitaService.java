package it.tris.scacchiera.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.tris.scacchiera.dto.MossaDTO;
import it.tris.scacchiera.dto.PartitaDTO;
import it.tris.scacchiera.dto.ScacchieraDTO;
import it.tris.scacchiera.entities.Partita;
import it.tris.scacchiera.entities.Scacchiera;
import it.tris.scacchiera.entities.Utente;
import it.tris.scacchiera.repo.PartitaRepository;
import it.tris.scacchiera.repo.ScacchieraRepository;
import it.tris.scacchiera.repo.UtenteRepository;
import it.tris.scacchiera.utils.TrisUtils;

@Service
public class PartitaService {
	
	@Autowired
	private TrisUtils tris;
	
	@Autowired
	private PartitaRepository partitaRepo;

	@Autowired
	private UtenteRepository utenteRepo;
	
	@Autowired
	private ScacchieraRepository scacchieraRepo;
	
	@Transactional
	public PartitaDTO creaPartita(Integer idUtente) {
		Partita p1 = new Partita();
		Utente u1 = utenteRepo.findById(idUtente).get();
		p1.setDataPartita(new Date());
		p1.setGiocatore1(u1);
		p1.setSimboloGiocatore1("X");
		p1.setSimboloGiocatore2("O");
		partitaRepo.save(p1);
		PartitaDTO partitaDto = new PartitaDTO();
		partitaDto.setGiocatore1(u1.getNome());
		partitaDto.setIdPartita(p1.getId());
		return partitaDto;
	}
	
	@Transactional
	public void partecipa(Integer idUtente,Integer idPartita) {
		Partita p1 = partitaRepo.findById(idPartita).get();
		p1.setGiocatore2(utenteRepo.findById(idUtente).get());
	}
	
	public List<PartitaDTO> leggiLista(Integer idUtente){
		return partitaRepo.findPartiteByGiocatore(idUtente);
	}
	
	@Transactional
	public ScacchieraDTO mossa(MossaDTO mossa) {
		Partita p1 = partitaRepo.findById(mossa.getIdPartita()).get();
		Utente u1 = utenteRepo.findById(mossa.getIdUtente()).get();
		Scacchiera sc = scacchieraRepo.findByPartitaId(p1.getId());
		ScacchieraDTO scDto = new ScacchieraDTO();
		if(partitaRepo.getGiocatore1(p1.getId()).getId()==u1.getId()) {
			tris.setPosition(mossa.getOrizzontalPos(), mossa.getVerticalPos(), p1.getSimboloGiocatore1());
			
// ==> SETTA LE COLONNE SUL DB      
			associaPos(scDto,sc,mossa.getOrizzontalPos(),mossa.getVerticalPos(),p1.getSimboloGiocatore1());
			updateDto(scDto,sc);
			if(tris.checkWinner(3)==3) {
				scDto.setUtenteInTurno("Giocatore 1 vince");
				scDto.setStatoPartita("Partita terminata");
				return scDto;
			}
			sc.setUtenteTurno(p1.getGiocatore2());
			scDto.setUtenteInTurno(p1.getGiocatore2().getNome());
			scDto.setStatoPartita("In corso");
			return scDto;
			
		}
		else  if(partitaRepo.getGiocatore2(p1.getId()).getId()==u1.getId()){
			tris.setPosition(mossa.getOrizzontalPos(), mossa.getVerticalPos(), p1.getSimboloGiocatore2());
			
// ==> SETTA LE COLONNE SUL DB 		
			associaPos(scDto,sc,mossa.getOrizzontalPos(),mossa.getVerticalPos(),p1.getSimboloGiocatore2());
			updateDto(scDto,sc);
			if(tris.checkWinner(-3)==-3) {
				scDto.setUtenteInTurno("Giocatore 2 vince");
				scDto.setStatoPartita("Partita terminata");
				
				return scDto;
			}
			sc.setUtenteTurno(p1.getGiocatore1());
			scDto.setUtenteInTurno(p1.getGiocatore1().getNome());
			scDto.setStatoPartita("In corso");
			return scDto;
		}
		return scDto;
	}
	
	private void associaPos(ScacchieraDTO scDto,Scacchiera sc,Integer horizontalP,Integer verticalP,String simbolo) {
		String str = horizontalP+""+verticalP;
		int s = 0;
		if(simbolo.equals("X")) {
			s=1;
		}else {
			s=-1;
		}
		switch(str) {
			case "00":
				sc.setPos00(s);
				//scDto.setPos00(s);
				break;
			case "01":
				sc.setPos01(s);
				//scDto.setPos01(s);
				break;
			case "02":
				sc.setPos02(s);
				//scDto.setPos02(s);
				break;
			case "10":
				sc.setPos10(s);
				//scDto.setPos10(s);
				break;
			case "11":
				sc.setPos11(s);
				//scDto.setPos11(s);
				break;
			case "12":
				sc.setPos12(s);
				//scDto.setPos12(s);
				break;
			case "20":
				sc.setPos20(s);
				//scDto.setPos20(s);
				break;
			case "21":
				sc.setPos21(s);
				//scDto.setPos21(s);
				break;
			case "22":
				sc.setPos22(s);
				//scDto.setPos22(s);
				break;
		}
	}
	
	public void updateDto(ScacchieraDTO scDto,Scacchiera sc) {
		scDto.setPos00(sc.getPos00());
		scDto.setPos01(sc.getPos01());
		scDto.setPos02(sc.getPos02());
		scDto.setPos10(sc.getPos10());
		scDto.setPos11(sc.getPos11());
		scDto.setPos12(sc.getPos12());
		scDto.setPos20(sc.getPos20());
		scDto.setPos21(sc.getPos21());
		scDto.setPos22(sc.getPos22());
	}
	
}
