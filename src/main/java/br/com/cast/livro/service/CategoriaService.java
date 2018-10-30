package br.com.cast.livro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livro.dto.CategoriaDTO;
import br.com.cast.livro.entity.Categoria;
import br.com.cast.livro.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<CategoriaDTO> listarCategoriasDTO() {

		List<Categoria> categorias = categoriaRepository.listarCategorias();
		List<CategoriaDTO> categoriasDTO = new ArrayList<>();

		for (Categoria categoria : categorias) {

			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setId(categoria.getId());
			categoriaDTO.setDescricao(categoria.getDescricao());
			categoriasDTO.add(categoriaDTO);

		}

		return categoriasDTO;

	}

	public Categoria buscarPorId(Integer id) {
		return categoriaRepository.buscarPorId(id);
	}

}
