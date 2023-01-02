package it.dipartimenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.dipartimenti.business.DipartimentoService;
import it.dipartimenti.dto.DipartimentoDTO;

@RestController
public class DipartimentoCtrl {
	
	@Autowired
	DipartimentoService dipartimentoService;

	@PostMapping(value="/dipartimento/create",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDipartimento(@RequestBody DipartimentoDTO dipDto) {
		dipartimentoService.createDipartimento(dipDto);
	}
	
	@GetMapping(value = "/dipartimento/read/{nome}",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public DipartimentoDTO getDipartimento(@PathVariable String nome) {
		return dipartimentoService.getDipartimento(nome);
	}
	
	@GetMapping(value = "/dipartimento/list",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<DipartimentoDTO> listaDipartimenti(){
		return dipartimentoService.getListaDipartimenti();
	}
}
