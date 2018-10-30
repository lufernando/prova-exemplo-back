package br.com.cast.livro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livro.dto.AutorDTO;
import br.com.cast.livro.entity.Autor;
import br.com.cast.livro.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public List<AutorDTO> listarAutoresDTO() {

		List<Autor> autores = autorRepository.listarAutores();
		List<AutorDTO> autoresDTO = new ArrayList<>();

		for (Autor autor : autores) {

			AutorDTO autorDTO = new AutorDTO();
			autorDTO.setId(autor.getId());
			autorDTO.setNome(autor.getNome());
			autorDTO.setPseudonimo(autor.getPseudonimo());
			autoresDTO.add(autorDTO);

		}

		return autoresDTO;

	}

	public Autor buscarPorId(Integer id) {
		return autorRepository.buscarPorId(id);
	}

}
