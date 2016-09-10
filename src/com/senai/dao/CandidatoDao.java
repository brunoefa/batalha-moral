package com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void atualizar(Candidato c) {
		String sql = "UPDATE candidato SET nome = ?, cargo = ?, cidade = ?, url = ?, partido = ?, numero = ? WHERE id = ?";
		
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
	
	public void excluir(Candidato c) {
		String sql = "DELETE FROM candidato WHERE id = ?";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		
	}
	
	public ArrayList<Candidato> buscarTodos() {
		String sql = "SELECT * FROM candidato";
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Candidato c = new Candidato();
				c = preencherCandidato(rs);
				listaCandidatos.add(c);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return listaCandidatos;
	}
	
	public ArrayList<Candidato> buscarUltimosCadastrados() {
		String sql = "SELECT * FROM candidato ORDER BY id DESC LIMIT 6";
		ArrayList<Candidato> ultimosCadastrados = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Candidato c = new Candidato();
				c = preencherCandidato(rs);
				ultimosCadastrados.add(c);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return ultimosCadastrados;
	}
	
	public Candidato buscarRandomico() {
		String sql = "SELECT * FROM candidato ORDER BY rand()";
		Candidato candidato = new Candidato();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				candidato = preencherCandidato(rs);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return candidato;
	}	
	
	public Candidato buscarPorId(Candidato candidato) {
		String sql = "SELECT * FROM candidato WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, candidato.getId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				candidato = preencherCandidato(rs);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return candidato;
	}
	
	private Candidato preencherCandidato(ResultSet rs) throws SQLException{
		Candidato c = new Candidato();
		c.setId(rs.getInt("id"));
		c.setNome(rs.getString("nome"));
		c.setCargo(rs.getString("cargo"));
		c.setUrl(rs.getString("url"));
		c.setPartido(rs.getString("partido"));
		c.setCidade(rs.getString("cidade"));
		c.setNumero(rs.getString("numero"));
		return c;
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement ps, Candidato c)  throws SQLException {
		ps.setString(1, c.getNome());
		ps.setString(2, c.getCargo());
		ps.setString(3, c.getCidade());
		ps.setString(4, c.getUrl());
		ps.setString(5, c.getPartido());
		ps.setString(6, c.getNumero());
		
		if (c.getId() != null) {
			ps.setInt(7, c.getId());
		}
		
		return ps;
	}
	
}











