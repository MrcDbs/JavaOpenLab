package it.dipartimenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.dipartimenti.business.ImpiegatoService;
import it.dipartimenti.dto.DipartimentoImpiegatoDTO;
import it.dipartimenti.dto.ImpiegatoDTO;

@RestController
public class ImpiegatoCtrl {
	
	@Autowired
	private ImpiegatoService impService;

	@PostMapping(value="/impiegato/create",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createImpiegato(@RequestBody ImpiegatoDTO impDto) {
		impService.createImpiegato(impDto);
	}
	
	@GetMapping(value="/impiegato/read/{codiceFiscale}",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public ImpiegatoDTO getImpiegato(@PathVariable String codiceFiscale) {
		return impService.getImpiegato(codiceFiscale);
	}
	
	@GetMapping(value="/impiegato/list",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<ImpiegatoDTO> getListImpiegato(){
		return impService.getListImpiegati();
	}
	
	@PutMapping(value="/impiegato/associate",consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void associaDipImp(@RequestBody DipartimentoImpiegatoDTO diDto) {
		impService.associaDipImp(diDto);
	}
}
