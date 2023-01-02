package it.dipartimenti.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.dipartimenti.dto.DipartimentoDTO;
import it.dipartimenti.dto.DipartimentoImpiegatoDTO;
import it.dipartimenti.dto.ImpiegatoDTO;
import it.dipartimenti.entities.Dipartimento;
import it.dipartimenti.entities.Impiegato;

@Repository
public class ImpiegatoRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void createImpiegato(ImpiegatoDTO impDto) {
		Impiegato imp = new Impiegato();
		imp.setNome(impDto.getNome());
		imp.setCognome(impDto.getCognome());
		imp.setCodiceFiscale(impDto.getCodiceFiscale());
		imp.setNumeroUfficio(impDto.getNumeroUfficio());
		
		//em.persist(imp);
		
		TypedQuery<Dipartimento> query = em.createQuery("select d from Dipartimento d left join fetch d.impiegati where d.nome=:dipNome", Dipartimento.class);
		query.setParameter("dipNome", impDto.getDipartimento());
		Dipartimento d1 = query.getSingleResult();
		d1.addImpiegato(imp);
		
		
	}
	
	@Transactional(readOnly=true)
	public ImpiegatoDTO getImpiegato(String codiceFiscale) {
		TypedQuery<Impiegato> query = em.createQuery("select i from Impiegato i where i.codiceFiscale=:impCF", Impiegato.class);
		Impiegato imp1 = query.setParameter("impCF", codiceFiscale).getSingleResult();
		String dip = imp1.getDipartimento().getNome();
		ImpiegatoDTO impDto = new ImpiegatoDTO(imp1.getNome(),imp1.getCognome(),imp1.getCodiceFiscale(),imp1.getNumeroUfficio(),dip);
		return impDto;
	}
	
	@Transactional(readOnly=true)
	public List<ImpiegatoDTO> getListaImpiegati(){
		TypedQuery<Impiegato> query = em.createQuery("select i from Impiegato i", Impiegato.class);
		List<ImpiegatoDTO> lista = new ArrayList<>();
		for(Impiegato imp1:query.getResultList()) {
			lista.add(new ImpiegatoDTO(imp1.getNome(),imp1.getCognome(),imp1.getCodiceFiscale(),imp1.getNumeroUfficio(),imp1.getDipartimento().getNome()));
		}
		return lista;
	}
	
	@Transactional
	public void associaDipartimentoImpiegato(DipartimentoImpiegatoDTO diDto) {
		TypedQuery<Impiegato> query1 = em.createQuery("select i from Impiegato i where i.codiceFiscale=:impCF", Impiegato.class);
		Impiegato imp = query1.setParameter("impCF", diDto.getImpiegatoCf()).getSingleResult();
		
		//imp.getDipartimento().removeImpiegato(imp);	
		
		TypedQuery<Dipartimento> query2 = em.createQuery("select d from Dipartimento d left join fetch d.impiegati where d.nome=:dipNome", Dipartimento.class);
		Dipartimento dip = query2.setParameter("dipNome", diDto.getDipartimentoNome()).getSingleResult();
		dip.addImpiegato(imp);
	}
}
