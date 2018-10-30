package br.com.cast.livro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.livro.entity.Categoria;


@Repository
public class CategoriaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Categoria buscarPorId(Integer id) {
		return em.find(Categoria.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategorias(){
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c ")
			.append("FROM ").append(Categoria.class.getName()).append(" c ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		
	}
}
