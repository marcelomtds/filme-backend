package br.com.cast.filme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filme.entity.Comentario;

@Repository
public class ComentarioRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void inserir(Comentario comentario) {
		em.persist(comentario);
	}

	@SuppressWarnings("unchecked")
	public List<Comentario> buscarTodos(Integer idFilme) {
			StringBuilder jpql = new StringBuilder();
			jpql.append("SELECT c").append(" FROM ").append(Comentario.class.getName()).append(" c")
			.append(" LEFT JOIN FETCH c.filme f ")
			.append(" LEFT JOIN FETCH c.usuario u WHERE f.id = (:idFilme)");
			Query query = em.createQuery(jpql.toString());
			query.setParameter("idFilme", idFilme);
			return query.getResultList();	
	}
}
