package br.com.cast.filme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filme.entity.Indicacao;

@Repository
public class IndicacaoRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void inserir(Indicacao indicacao) {
		em.persist(indicacao);
	}

	@SuppressWarnings("unchecked")
	public List<Indicacao> buscarPorId(Integer id) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT i").append(" FROM ").append(Indicacao.class.getName()).append(" i")
			.append(" LEFT JOIN FETCH i.filme f ")
			.append(" LEFT JOIN FETCH i.usuario u WHERE i.destino = (:id)");
			Query query = em.createQuery(jpql.toString());
			query.setParameter("id", id);
			return query.getResultList();	
	}

}
