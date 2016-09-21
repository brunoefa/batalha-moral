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
		String sql = "INSERT INTO usuario (nome, email, senha, lembrete) VALUES (?,?,?,?)";
		
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
	
	public Usuario preencherUsuario(ResultSet rs) throws SQLException{
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNome(rs.getString("nome"));
		u.setEmail(rs.getString("email"));
		u.setSenha(rs.getString("senha"));
		u.setLembrete(rs.getString("lembrete"));
		return u;
	}
	
	private PreparedStatement preencherPreparedStatement(PreparedStatement ps, Usuario u)  throws SQLException {
		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getSenha());
		ps.setString(4, u.getLembrete());
		return ps;
	}
		
}











