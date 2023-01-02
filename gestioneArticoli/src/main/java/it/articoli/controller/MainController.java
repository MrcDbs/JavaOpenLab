package it.articoli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.articoli.dto.ArticoloDTO;
import it.articoli.dto.ArticoloFiltroDTO;
import it.articoli.dto.CategoriaDTO;
import it.articoli.dto.PageDTO;
import it.articoli.service.ArticoloService;
import it.articoli.service.CategoriaService;

@RestController
public class MainController {

	private final ArticoloService articoloService;
	private final CategoriaService categoriaService;
	
	@Autowired
	public MainController( ArticoloService articoloService,CategoriaService categoriaService) {
		this.articoloService=articoloService;
		this.categoriaService=categoriaService;
	}
	
	@PostMapping(value="/articoli/crea",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createArtico(@RequestBody ArticoloDTO articolo) {
		articoloService.createArticolo(articolo);
	}
	
	@PostMapping(value="/articoli/associa/articolo")
	@ResponseStatus(HttpStatus.CREATED)
	public void associaArticolo(@RequestParam Integer articoloId,@RequestParam String categoriaNome) {
		articoloService.associateArticoloToCategoria(articoloId, categoriaNome);
	}
	
	@GetMapping(value="/articoli/read",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public PageDTO readArticoliPages(@RequestParam Integer numPage,@RequestParam Integer numOfElements) {
		return articoloService.findAllArticoli(numPage, numOfElements);
	}
	
	@GetMapping(value="/articoli/readBy/id/{id}",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public ArticoloDTO readById(@PathVariable Integer id) {
		return articoloService.readById(id);
	}
	
	@GetMapping(value="/articoli/readBy/categoria",consumes="application/json",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public PageDTO readBYCategoria(@RequestBody ArticoloFiltroDTO filtro) {
		return null;
	}
	
	@PostMapping(value="/categoria/create",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCategoria(@RequestBody CategoriaDTO categoria) {
		 categoriaService.createCategoria(categoria);
	}
	
}
