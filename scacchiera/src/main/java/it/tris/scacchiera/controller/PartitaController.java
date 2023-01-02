package it.tris.scacchiera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.tris.scacchiera.dto.MossaDTO;
import it.tris.scacchiera.dto.PartitaDTO;
import it.tris.scacchiera.dto.ScacchieraDTO;
import it.tris.scacchiera.dto.UtenteDTO;
import it.tris.scacchiera.service.PartitaService;
import it.tris.scacchiera.service.ScacchieraService;
import it.tris.scacchiera.service.UtenteService;

@RestController
public class PartitaController {
	
	@Autowired
	private PartitaService partitaService;
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private ScacchieraService scacchieraService;

	@PostMapping(value="/partita/registraUtente",consumes="application/json",produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UtenteDTO registraUtente(@RequestBody UtenteDTO utenteDto) {
		return utenteService.registraUtente(utenteDto);
	}
	
	@PostMapping(value="/partita/creaPartita/{idUtente}",produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public PartitaDTO creaPartita(@PathVariable Integer idUtente) {
		return partitaService.creaPartita(idUtente);
	}
	
	@PutMapping(value="/partita/partecipa")
	@ResponseStatus(HttpStatus.OK)
	public void partecipa(@RequestParam(name="idUtente") Integer idUtente,@RequestParam(name="idPartita") Integer idPartita) {
		partitaService.partecipa(idUtente, idPartita);
	}
	
	@PostMapping(value="/partita/creaScacchiera")
	@ResponseStatus(HttpStatus.CREATED)
	public ScacchieraDTO scacchiera(@RequestParam(name="idUtente") Integer idUtente,@RequestParam(name="idPartita") Integer idPartita) {
		return scacchieraService.creaScacchiera(idUtente, idPartita);
	}
	
	@GetMapping(value="/partita/leggi/lista/{idUtente}")
	@ResponseStatus(HttpStatus.OK)
	public List<PartitaDTO> leggiListaPartite(@PathVariable Integer idUtente){
		return partitaService.leggiLista(idUtente);
	}
	
	@PostMapping(value="/partita/mossa",consumes="application/json",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public ScacchieraDTO mossa(@RequestBody MossaDTO mossa) {
		return partitaService.mossa(mossa);
	}
	
}
