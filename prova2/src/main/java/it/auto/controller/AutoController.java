package it.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.auto.dto.AutoDTO;
import it.auto.dto.PageDTO;
import it.auto.service.AutoService;

@RestController
public class AutoController {

	private final AutoService autoService;
	
	@Autowired
	public AutoController(AutoService autoService) {
		this.autoService=autoService;
	}
	
	@PutMapping(value="/crea/auto",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void creaAuto(@RequestBody AutoDTO autoDto) {
		autoService.creaAuto(autoDto);
	}
	
	@PostMapping(value="/modifica/auto",consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void modificaAuto(@RequestBody AutoDTO autoDto, @RequestParam Integer id) {
		autoService.modifica(autoDto,id);
	}
	
	@DeleteMapping(value="/delete/auto")
	@ResponseStatus(HttpStatus.OK)
	public void cancellaAuto(@RequestParam Integer id) {
		autoService.cancellaAuto(id);
	}
	
	@GetMapping(value="/leggi/autoBy/id/{id}",produces="application/json")
	public ResponseEntity<AutoDTO> leggiPerId(@PathVariable Integer id){
		return autoService.readById(id);
	}
	
	@GetMapping(value="/leggi/autoBy/targa/{targa}",produces="application/json")
	public ResponseEntity<AutoDTO> leggiPerTarga(@PathVariable String targa){
		return autoService.readByTarga(targa);
	}
	
	@GetMapping(value="/leggi/autoBy/modello/{modello}",produces="application/json")
	public ResponseEntity<List<AutoDTO>> leggiPerModello(@PathVariable String modello){
		return autoService.readByModello(modello);
	}
	
	@GetMapping(value="/leggi/pagina",consumes="application/json",produces="application/json")
	public ResponseEntity<PageDTO> leggiPaginePerModello(@RequestBody PageDTO page){
		return autoService.readPage(page);
	}
	
}
