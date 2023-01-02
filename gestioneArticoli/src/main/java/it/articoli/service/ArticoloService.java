package it.articoli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.articoli.composite.CategoriaNome;
import it.articoli.dto.ArticoloDTO;
import it.articoli.dto.ArticoloFiltroDTO;
import it.articoli.dto.PageDTO;
import it.articoli.entities.Articolo;
import it.articoli.entities.Categoria;
import it.articoli.repo.ArticoliRepo;
import it.articoli.repo.CategoriaRepo;

@Service
public class ArticoloService {

	private final ArticoliRepo articoloRepo;
	private final CategoriaRepo categoriaRepo;
	
	@Autowired
	public ArticoloService(ArticoliRepo articoloRepo,CategoriaRepo categoriaRepo) {
		this.articoloRepo=articoloRepo;
		this.categoriaRepo=categoriaRepo;
	}
	
	@Transactional
	public void createArticolo(ArticoloDTO articolo) {
		Articolo a = new Articolo();
		a.setTitolo(articolo.getNome());
		a.setDescrizione(articolo.getDescrizione());
		articoloRepo.save(a);
	}
	
	@Transactional
	public void associateArticoloToCategoria(Integer articoloId,String categoriaNome) {
		Articolo a =  articoloRepo.findById(articoloId).get();
		Categoria c = categoriaRepo.findById(new CategoriaNome(categoriaNome)).get();
		a.setCategoria(c);
	}
	
	@Transactional(readOnly=true)
	public PageDTO findAllArticoli(Integer numPage,Integer numOfElements){
		Pageable pageable = PageRequest.of(numPage-1, numOfElements);
		Page<Articolo> page = articoloRepo.findAll(pageable);
		List<Articolo> lista = page.getContent();
		List<ArticoloDTO> listaDto = new ArrayList<>();
		for(Articolo a:lista) {
			listaDto.add(new ArticoloDTO(a.getCategoria().getNome().getNome(),a.getDescrizione()));
		}
		PageDTO pageDto = new PageDTO(numPage,page.getNumberOfElements(),listaDto); 
		return pageDto;
		
	}
	
	@Transactional(readOnly=true)
	public ArticoloDTO readById(Integer id) {
		Articolo a = articoloRepo.findById(id).get();
		 ArticoloDTO adto = new ArticoloDTO(a.getTitolo(),a.getDescrizione());
		 return adto;
	}
	
	@Transactional(readOnly=true)
	public ArticoloDTO readByTitolo(ArticoloFiltroDTO filtro) {
	
		return  null;//articoloRepo.
	}
	
	
}
