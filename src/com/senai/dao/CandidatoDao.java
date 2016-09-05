package com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.senai.model.Candidato;

public class CandidatoDao {

	private Connection connection;
	
	public CandidatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Candidato c) {
		String sql = "INSERT INTO candidato (nome, cargo, cidade, url, partido, numero) VALUES (?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps = preencherPreparedStatement(ps, c);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement ps, Candidato c)  throws SQLException {
		ps.setString(1, c.getNome());
		ps.setString(2, c.getCargo());
		ps.setString(3, c.getCidade());
		ps.setString(4, c.getUrl());
		ps.setString(5, c.getPartido());
		ps.setString(6, c.getNumero());
		return ps;
	}
	
}











