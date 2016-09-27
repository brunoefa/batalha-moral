package com.senai.model;

public class Usuario {

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String lembrete;
	private String recuperacao;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLembrete() {
		return lembrete;
	}
	public void setLembrete(String lembrete) {
		this.lembrete = lembrete;
	}
	public String getRecuperacao() {
		return recuperacao;
	}
	public void setRecuperacao(String recuperacao) {
		this.recuperacao = recuperacao;
	}
	
	public String getPrimeiroNome() {
		if (nome.contains(" ")) {
			return nome.substring(0, nome.indexOf(" "));
		}
		return nome;
	}
	
}
