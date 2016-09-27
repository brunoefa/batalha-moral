package com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.senai.model.Usuario;

public class UsuarioDao {

	private Connection connection;
	
	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public Usuario buscarPorId(Usuario usuario) {
		Usuario usuarioBanco = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, usuario.getId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				usuarioBanco = preencherUsuario(rs);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return usuarioBanco;
	}
	
	public Usuario buscarPorEmail(Usuario usuario) {
		Usuario usuarioBanco = new Usuario();
		String sql = "SELECT * FROM usuario WHERE LCASE(email) = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getEmail().toLowerCase());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				usuarioBanco = preencherUsuario(rs);
			}
			
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

		return usuarioBanco;
	}
	
	public void salvar(Usuario u) {
		String sql = "INSERT INTO usuario (nome, email, senha, lembrete, recuperacao) VALUES (?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps = preencherPreparedStatement(ps, u);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void atualizarRecuperacao(Usuario u) {
		String sql = "UPDATE usuario SET recuperacao = ? WHERE id = ?";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, u.getRecuperacao());
			ps.setInt(2, u.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public void atualizarSenha(Usuario u) {
		String sql = "UPDATE usuario SET senha = ?, recuperacao = ? WHERE id = ?";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, u.getSenha());
			ps.setString(2, null);
			ps.setInt(3, u.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public Usuario preencherUsuario(ResultSet rs) throws SQLException{
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNome(rs.getString("nome"));
		u.setEmail(rs.getString("email"));
		u.setSenha(rs.getString("senha"));
		u.setLembrete(rs.getString("lembrete"));
		u.setRecuperacao(rs.getString("recuperacao"));
		return u;
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement ps, Usuario u)  throws SQLException {
		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getSenha());
		ps.setString(4, u.getLembrete());
		ps.setString(5, null);
		return ps;
	}
		
}











