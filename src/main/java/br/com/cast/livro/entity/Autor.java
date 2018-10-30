package br.com.cast.livro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor", schema = "livroapi")
public class Autor {
	
	@Id
	@SequenceGenerator(name = "gerador_autor_seq", schema = "livroapi", sequenceName = "autor_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "gerador_autor_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String nome;
	private String pseudonimo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
	
	

}
