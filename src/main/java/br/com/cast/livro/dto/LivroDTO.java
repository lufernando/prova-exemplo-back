package br.com.cast.livro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class LivroDTO {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("titulo")
	private String titulo;
	
	@JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING, timezone="GMT-3")
	@JsonProperty("data_de_publicacao")
	private String dataDePublicacao;
	
	@JsonProperty("id_autor")
	private AutorDTO autorDTO;
	
	@JsonProperty("id_categoria")
	private CategoriaDTO categoriaDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(String dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

}
