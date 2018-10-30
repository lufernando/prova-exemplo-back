package br.com.cast.livro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livro.dto.LivroDTO;
import br.com.cast.livro.service.LivroService;

@RestController
@RequestMapping(path="/livro")
public class LivroApi {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(path="/buscarTodos")
	public List<LivroDTO> getLivros(){
		return livroService.buscarLivrosDTO();
	}
	
	@GetMapping(path="/{id}")
	public LivroDTO buscaPorId(@PathVariable ("id") Integer id) {
		LivroDTO ldto = livroService.buscarParaAlterar(id);
		return ldto;
	}
	
	@PostMapping(path="/inserir")
	public LivroDTO inserir(@RequestBody LivroDTO livroDTO) {
		livroService.inserir(livroDTO);
		return livroDTO;
	}
	
	@DeleteMapping(path="/{id}")
	public void deletar(@PathVariable ("id") Integer id) {
		livroService.excluir(id);
		System.out.println(id);
	}
	
	@PutMapping(path="/alterar")
	public LivroDTO alterar(@RequestBody LivroDTO livroDTO) {
		livroService.alterar(livroDTO);
		
		return livroDTO;
	}

}
