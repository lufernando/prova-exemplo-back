package br.com.cast.livro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categoria", schema="livroapi")
public class Categoria {
	
	@Id
	@SequenceGenerator(name = "gerador_categoria_seq", schema = "livroapi", sequenceName = "categoria_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "gerador_categoria_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
