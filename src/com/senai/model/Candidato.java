package com.senai.model;

public class Candidato {
	
	private Integer id;
	private String nome;
	private String cargo;
	private String url;
	private String cidade;
	private String partido;
	private String numero;
	

	public Candidato() {
	
	}

	public Candidato(Integer id) {
		super();
		this.id = id;
	}

	public Candidato(String nome, String cargo, String url, String cidade, String partido, String numero) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.url = url;
		this.cidade = cidade;
		this.partido = partido;
		this.numero = numero;
	}
	
	
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
