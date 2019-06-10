package com.usjt.Aula3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dia {
	
	public Dia() {};

	public Dia(Tempo tempo, Long id, String nome) {
		super();
		this.tempo = tempo;
		this.id = id;
		this.nome = nome;
	}
	
	@OneToOne(optional=false)
	private Cidade cidade;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@OneToOne(optional=false)
	private Tempo tempo;
	
	public Tempo getTempo() {
		return tempo;
	}
	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddia")
	private Long id;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
