package br.com.cast.livro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livro.dto.AutorDTO;
import br.com.cast.livro.entity.Autor;
import br.com.cast.livro.service.AutorService;

@RestController
@RequestMapping(path="/autor")
public class AutorApi {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public List<AutorDTO> getAutores(){
		return autorService.listarAutoresDTO();
	}
	
	@GetMapping(path="/{id}")
	public Autor getAutoresById(@PathVariable ("id") Integer id){
		return autorService.buscarPorId(id);
	}

}
