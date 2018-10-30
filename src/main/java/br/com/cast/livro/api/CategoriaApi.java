package br.com.cast.livro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livro.dto.CategoriaDTO;
import br.com.cast.livro.entity.Categoria;
import br.com.cast.livro.service.CategoriaService;

@RestController
@RequestMapping(path="/categoria")
public class CategoriaApi {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDTO> getCategorias(){
		return categoriaService.listarCategoriasDTO();
	}
	
	@GetMapping(path="/{id}")
	public Categoria getLivrosById(@PathVariable ("id") Integer id){
		return categoriaService.buscarPorId(id);
	}

}
