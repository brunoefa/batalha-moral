package com.senai.model;

public class Batalha {
	
	private Integer id;
	private Candidato candidato1;
	private Candidato candidato2;
	private Candidato vencedor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Candidato getCandidato1() {
		return candidato1;
	}
	public void setCandidato1(Candidato candidato1) {
		this.candidato1 = candidato1;
	}
	public Candidato getCandidato2() {
		return candidato2;
	}
	public void setCandidato2(Candidato candidato2) {
		this.candidato2 = candidato2;
	}
	public Candidato getVencedor() {
		return vencedor;
	}
	public void setVencedor(Candidato vencedor) {
		this.vencedor = vencedor;
	}
}
