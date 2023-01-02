package it.articoli.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import it.articoli.dto.ArticoloDTO;
import it.articoli.entities.Articolo;

@Repository
public class ArticoloCustomRepoImpl implements ArticoloCustomRepo<Articolo>{
	
	@PersistenceContext
	private  EntityManager em;
	

	@Override
	public Articolo readWithCriteriaByTitolo(String filtro) {
		// SIMPLE CRITERIA QUERY
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<Articolo> criteriaQuery = criteria.createQuery(Articolo.class);
		
	// CREATE ROOT	
		Root articolo = criteriaQuery.from(Articolo.class);
		
	// CREATE PREDICATE ( CONDITION )	
		Predicate predicate = criteria.equal(articolo.get("titolo"), criteria.parameter(String.class,"titolo"));
		
	// BUILD QUERY WITH .SELECT(ROOT).WHERE(PREDICATE)		
		criteriaQuery.select(articolo).where(predicate);
		TypedQuery<Articolo> query = em.createQuery(criteriaQuery);
		query.setParameter("titolo",filtro );
		return query.getSingleResult();
	}

}
