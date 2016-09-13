package com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.senai.model.Batalha;
import com.senai.model.Candidato;

public class BatalhaDao {

	private Connection connection;
	
	public BatalhaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Batalha b) {
		String sql = "INSERT INTO batalha (candidato1, candidato2, vencedor) VALUES (?,?,?)";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps = preencherPreparedStatement(ps, b);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		
	}
	
	public Batalha gerarBatalha() {
		String sql = "SELECT * FROM candidato ORDER BY rand() LIMIT 2";
		Batalha batalha = new Batalha();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			batalha = preencherBatalha(rs);
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return batalha;
	}	
	
	private Batalha preencherBatalha(ResultSet rs) throws SQLException{
		Batalha b = new Batalha();
		CandidatoDao candidatoDao = new CandidatoDao();
		
		if (rs.next()) {
			Candidato c1 = candidatoDao.preencherCandidato(rs);
			b.setCandidato1(c1);
		}
		
		if (rs.next()) {
			Candidato c2 = candidatoDao.preencherCandidato(rs);
			b.setCandidato2(c2);
		}
		
		return b;
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement ps, Batalha b)  throws SQLException {
		ps.setInt(1, b.getCandidato1().getId());
		ps.setInt(2, b.getCandidato2().getId());
		ps.setInt(3, b.getVencedor().getId());
		return ps;
	}
	
}











