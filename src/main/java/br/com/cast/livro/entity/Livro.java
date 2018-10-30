package br.com.cast.livro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="livro", schema="livroapi")
public class Livro {
	

	@Id
	@SequenceGenerator(name = "gerador_livro_seq", schema = "prova", sequenceName = "livro_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "gerador_livro_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String titulo;
	
	@Column(name="data_de_publicacao")
	private Date data_de_publicacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_autor")
	private Autor autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_categoria")
	private Categoria categoria;

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

	public Date getData_de_publicacao() {
		return data_de_publicacao;
	}

	public void setData_de_publicacao(Date data_de_publicacao) {
		this.data_de_publicacao = data_de_publicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
