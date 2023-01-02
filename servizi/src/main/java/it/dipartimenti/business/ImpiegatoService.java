package it.dipartimenti.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dipartimenti.dto.DipartimentoImpiegatoDTO;
import it.dipartimenti.dto.ImpiegatoDTO;
import it.dipartimenti.repo.ImpiegatoRepo;

@Service
public class ImpiegatoService {
	
	@Autowired
	ImpiegatoRepo impRepo;
	
	public void createImpiegato(ImpiegatoDTO impDto) {
		impRepo.createImpiegato(impDto);
	}
	
	public ImpiegatoDTO getImpiegato(String codiceFiscale) {
		return impRepo.getImpiegato(codiceFiscale);
	}
	
	public List<ImpiegatoDTO> getListImpiegati(){
		return impRepo.getListaImpiegati();
	}
	
	public void associaDipImp(DipartimentoImpiegatoDTO diDto) {
		impRepo.associaDipartimentoImpiegato(diDto);
	}
}
