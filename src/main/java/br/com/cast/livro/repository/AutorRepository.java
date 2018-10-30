package br.com.cast.livro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.livro.entity.Autor;


@Repository
public class AutorRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Autor buscarPorId(Integer id) {
		return em.find(Autor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Autor> listarAutores() {

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT a ").append("FROM ").append(Autor.class.getName()).append(" a ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();

	}

}
