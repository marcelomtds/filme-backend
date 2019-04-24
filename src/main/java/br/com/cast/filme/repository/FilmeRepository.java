package br.com.cast.filme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filme.entity.Filme;

@Repository
public class FilmeRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void inserir(Filme filme) {
		em.persist(filme);
	}

	@SuppressWarnings("unchecked")
	public List<Filme> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT f").append(" FROM ").append(Filme.class.getName()).append(" f");
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}

	public Filme buscarPorId(Integer id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT f").append(" FROM ").append(Filme.class.getName()).append(" f where id = (:id)");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", id);

		try {
			return (Filme) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void alterar(Filme filme) {
		em.merge(filme);
	}

	@Transactional
	public void excluir(Filme filme) {
		em.remove(filme);
	}

	@SuppressWarnings("unchecked")
	public List<Filme> buscarPorTitulo(String titulo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT f").append(" FROM ").append(Filme.class.getName())
				.append(" f where lower (titulo) like (:titulo)");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("titulo", "%" + titulo.toLowerCase() + "%");
		return query.getResultList();
	}

	public Filme buscarPorIdOMDb(String id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT f").append(" FROM ").append(Filme.class.getName()).append(" f where idimdb = (:id)");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", id);
		try {
			return (Filme) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void inserirDetalhes(Filme filmeAtualizado) {
		em.merge(filmeAtualizado);
	}
}
