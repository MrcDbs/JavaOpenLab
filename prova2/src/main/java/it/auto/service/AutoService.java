package it.auto.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.auto.dto.AutoDTO;
import it.auto.dto.PageDTO;
import it.auto.entities.Auto;
import it.auto.repo.AutoRepo;

@Service
public class AutoService implements AServiceCrud{
	
	private final AutoRepo autoRepo;
	
	@Autowired
	public AutoService(AutoRepo autoRepo) {
		this.autoRepo=autoRepo;
	}

	@Transactional
	public void creaAuto(AutoDTO autoDto) {
		Auto a1 = new Auto();
		a1.setTarga(autoDto.getTarga());
		a1.setModello(autoDto.getModello());
		a1.setDataProduzione(autoDto.getDataProduzione());
		a1.setCosto(autoDto.getCosto());
		autoRepo.save(a1);
	}
	
	@Transactional
	public void modifica(AutoDTO autoDto, Integer id) {
		Auto a1 = new Auto();
		a1.setId(id);
		a1.setTarga(autoDto.getTarga());
		a1.setModello(autoDto.getModello());
		a1.setDataProduzione(autoDto.getDataProduzione());
		a1.setCosto(autoDto.getCosto());
		autoRepo.save(a1);
	}
	
	@Transactional
	public void cancellaAuto(Integer id) {
		autoRepo.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public ResponseEntity<AutoDTO> readById(Integer id) {
		AutoDTO aDto = autoRepo.readById(id);
		HttpStatus hs = HttpStatus.NOT_FOUND;
		if(aDto!=null) {
			hs =  HttpStatus.OK;
		}
		return new ResponseEntity<>(aDto,hs);
	}
	
	@Transactional(readOnly=true)
	public ResponseEntity<AutoDTO> readByTarga(String targa) {
		AutoDTO aDto = autoRepo.readByTarga(targa);
		HttpStatus hs = HttpStatus.NOT_FOUND;
		if(aDto!=null) {
			hs =  HttpStatus.OK;
			
		}
		return new ResponseEntity<>(aDto,hs);
	}
	
	@Transactional(readOnly=true)
	public ResponseEntity<List<AutoDTO>> readByModello(String modello) {
		List<AutoDTO> aDtoList = autoRepo.readByModello(modello);
		HttpStatus hs = HttpStatus.NOT_FOUND;
		if(aDtoList!=null && !aDtoList.isEmpty()) {
			hs =  HttpStatus.OK;
		}
		return new ResponseEntity<>(aDtoList,hs);
	}
	
	@Transactional(readOnly=true)
	public ResponseEntity<PageDTO> readPage(PageDTO pageDto) {
		Pageable pageable = PageRequest.of(pageDto.getNumPage()-1, pageDto.getNumOfElements());
		Page<Auto> paginaAuto = autoRepo.findAll(pageable);
		List<Auto> listaAuto = paginaAuto.getContent();
		List<AutoDTO> listaDTO = new ArrayList<>();
		for(Auto a:listaAuto) {
			listaDTO.add(new AutoDTO(a.getTarga(),a.getModello(),a.getDataProduzione(),a.getCosto()));
		}
		PageDTO pDto = new PageDTO();
		
		pDto.setListaAuto(listaDTO);
		pDto.setNumPage(pageDto.getNumPage());
		pDto.setNumOfElements(pageDto.getNumOfElements());
		
		if(pDto.getListaAuto()==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(pDto,HttpStatus.OK);
		}
	}
}
