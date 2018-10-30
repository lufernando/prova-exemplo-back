package br.com.cast.livro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livro.dto.AutorDTO;
import br.com.cast.livro.dto.CategoriaDTO;
import br.com.cast.livro.dto.LivroDTO;
import br.com.cast.livro.entity.Autor;
import br.com.cast.livro.entity.Categoria;
import br.com.cast.livro.entity.Livro;
import br.com.cast.livro.repository.AutorRepository;
import br.com.cast.livro.repository.CategoriaRepository;
import br.com.cast.livro.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;

	
	//BUSCA TODOS NO BANCO
	public List<LivroDTO> buscarLivrosDTO() {

		List<Livro> livros = livroRepository.listarLivros();
		List<LivroDTO> livrosDTO = new ArrayList<>();

		for (Livro l : livros) {
			LivroDTO livroDTO = new LivroDTO();
			livroDTO.setId(l.getId());
			livroDTO.setTitulo(l.getTitulo());
			livroDTO.setDataDePublicacao(dateToString(l.getData_de_publicacao()));

			AutorDTO autorDTO = new AutorDTO();
			autorDTO.setId(l.getAutor().getId());
			autorDTO.setNome(l.getAutor().getNome());
			autorDTO.setPseudonimo(l.getAutor().getPseudonimo());

			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setId(l.getCategoria().getId());
			categoriaDTO.setDescricao(l.getCategoria().getDescricao());

			livroDTO.setAutorDTO(autorDTO);
			livroDTO.setCategoriaDTO(categoriaDTO);

			livrosDTO.add(livroDTO);

		}

		return livrosDTO;

	}
	
	// VERIRICA O TITULO DO LIVRO 
	public Livro validandoAlteracao(LivroDTO livroDTO) {

		Livro livroNovo = livroRepository.verificarDuplicidade(livroDTO.getTitulo(), livroDTO.getId());
		return livroNovo;

	}
	
	// INSERIR 
	public Livro inserir(LivroDTO livroDTO)  {
			
		Livro livroNovo = validandoAlteracao(livroDTO);
		
		Autor autor = autorRepository.buscarPorId(livroDTO.getAutorDTO().getId());
		Categoria categoria = categoriaRepository.buscarPorId(livroDTO.getCategoriaDTO().getId());
		
		Livro livro = new Livro();
		livro.setTitulo(livroDTO.getTitulo());
		livro.setData_de_publicacao(StringToDate(livroDTO.getDataDePublicacao()));
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		if(livroNovo != null) {
			return null;
		}else {
			livroRepository.inserir(livro);
			return livro;
		}
		

	}

	// EXCLUIR 
	public void excluir(Integer id) {
		Livro livro = livroRepository.buscarPorId(id);
		livroRepository.remover(livro);
	}

	// ALTERAR 
	public Livro alterar(LivroDTO livroDTO) {
		
		Livro livroComparativo = validandoAlteracao(livroDTO);
		Livro livro = conversorEntidade(livroDTO);
		
		if((livroComparativo != null) && (livroComparativo.getAutor().getId().equals(livro.getAutor().getId())) 
				&& (livroComparativo.getCategoria().getId().equals(livro.getCategoria().getId()))) {
			return null;
		}else {
			livroRepository.alterar(livro);
			return livro;
		}

	}
	
	
	//------------CONVERSÕES------------
	public Livro conversorEntidade(LivroDTO livroDTO) {

		Livro livro = new Livro();
		livro.setId(livroDTO.getId());
		livro.setTitulo(livroDTO.getTitulo());
		livro.setData_de_publicacao(StringToDate(livroDTO.getDataDePublicacao()));

		Autor autor = new Autor();
		autor.setId(livroDTO.getAutorDTO().getId());
		autor.setNome(livroDTO.getAutorDTO().getNome());
		autor.setPseudonimo(livroDTO.getAutorDTO().getPseudonimo());

		Categoria categoria = new Categoria();
		categoria.setId(livroDTO.getCategoriaDTO().getId());
		categoria.setDescricao(livroDTO.getCategoriaDTO().getDescricao());

		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		return livro;

	}

	public LivroDTO buscarParaAlterar(Integer id) {

		Livro livro = livroRepository.buscarPorId(id);
		LivroDTO livroDTO = conversorDTO(livro);

		return livroDTO;

	}

	public LivroDTO conversorDTO(Livro livro) {

		LivroDTO livroDTO = new LivroDTO();
		livroDTO.setId(livro.getId());
		livroDTO.setTitulo(livro.getTitulo());
		livroDTO.setDataDePublicacao(dateToString(livro.getData_de_publicacao()));

		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setId(livro.getAutor().getId());
		autorDTO.setNome(livro.getAutor().getNome());
		autorDTO.setPseudonimo(livro.getAutor().getPseudonimo());

		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setId(livro.getCategoria().getId());
		categoriaDTO.setDescricao(livro.getCategoria().getDescricao());

		livroDTO.setAutorDTO(autorDTO);
		livroDTO.setCategoriaDTO(categoriaDTO);

		return livroDTO;

	}
	
	
	//-----------STRING PARA DATE-----------
	public Date StringToDate(String dataAFormatar) {
		Date data = null;
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			data = formatador.parse(dataAFormatar);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	//-----------DATA PARA STRING-----------
	private String dateToString(Date dtPublicacao) {
		String dataFormatadaToString = "";
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatadaToString = formatador.format(dtPublicacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataFormatadaToString;
	}

}
