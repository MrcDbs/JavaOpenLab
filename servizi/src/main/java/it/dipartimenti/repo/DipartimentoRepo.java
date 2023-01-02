package it.dipartimenti.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import it.dipartimenti.dto.DipartimentoDTO;
import it.dipartimenti.entities.Dipartimento;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DipartimentoRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
    public void createDipartimento(DipartimentoDTO dipDTO) {
		Dipartimento d1 = new Dipartimento();
		d1.setCitta(dipDTO.getCitta());
		d1.setIndirizzo(dipDTO.getIndirizzo());
		d1.setNome(dipDTO.getNome());
		em.persist(d1);
	}
	
	@Transactional(readOnly = true)
	public DipartimentoDTO getDipartimento(String nome) {
		TypedQuery<Dipartimento> query = em.createQuery("select d from Dipartimento d where d.nome=:dipNome",Dipartimento.class);
		query.setParameter("dipNome", nome);
		Dipartimento d1 = query.getSingleResult();
		DipartimentoDTO dipDto = new DipartimentoDTO();
		dipDto.setCitta(d1.getCitta());
		dipDto.setIndirizzo(d1.getIndirizzo());
		dipDto.setNome(d1.getNome());
		return dipDto;
	}
	
	@Transactional(readOnly = true)
	public List<DipartimentoDTO> getListaDipartimenti(){
		TypedQuery<Dipartimento> query = em.createQuery("select d from Dipartimento d", Dipartimento.class);
		List<DipartimentoDTO> lista = new ArrayList<>();
		for(Dipartimento d:query.getResultList()) {
			lista.add(new DipartimentoDTO(d.getNome(),d.getCitta(),d.getIndirizzo()));
		}
		return lista;
	}
}
