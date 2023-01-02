package it.dipartimenti.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dipartimenti.dto.DipartimentoDTO;
import it.dipartimenti.repo.DipartimentoRepo;

@Service
public class DipartimentoService {
	
	@Autowired
	DipartimentoRepo dipRepo;
	

	public void createDipartimento(DipartimentoDTO dipDTO) {
		dipRepo.createDipartimento(dipDTO);
	}
	
	public DipartimentoDTO getDipartimento(String nome) {
		return dipRepo.getDipartimento(nome);
	}
	
	public List<DipartimentoDTO> getListaDipartimenti(){
		return dipRepo.getListaDipartimenti();
	}
}
