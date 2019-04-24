package br.com.cast.filme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filme.dto.UsuarioDTO;
import br.com.cast.filme.entity.Usuario;

@Repository
public class UsuarioRepositry {
		
	@PersistenceContext
	private EntityManager em;
	
	public Usuario autenticar(String email, String senha) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT u").append(" FROM ").append(Usuario.class.getName()).append(" u where email = (:email) and senha = (:senha)");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		try {		
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void inserir(Usuario usuario) {
		em.persist(usuario);
		
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioDTO> buscarTodos(Integer id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT u").append(" FROM ").append(Usuario.class.getName()).append(" u where id != (:id)");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", id);
		return query.getResultList();
	}
}
