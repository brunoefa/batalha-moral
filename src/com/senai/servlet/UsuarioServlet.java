package com.senai.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.dao.UsuarioDao;
import com.senai.model.Usuario;
import com.senai.util.Criptografia;
import com.senai.util.SendMail;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioDao usuarioDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        usuarioDao = new UsuarioDao();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("cadastrar".equals(acao)) {
			cadastrar(request, response);
		} else if ("logar".equals(acao)) {
			logar(request, response);
		} else if ("salvar".equals(acao)) {
			salvar(request, response);
		} else if ("esqueci".equals(acao)) {
			esqueci(request, response);
		} else if ("recuperar".equals(acao)) {
			recuperar(request, response);
		} else {
			mostrarLogin(request, response);
		}
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao(request, response, "usuario-form.jsp");
	}
	
	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao(request, response, "login.jsp");
	}
	
	private void esqueci(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao(request, response, "usuario-recuperar.jsp");
	}
	
	private void recuperar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = capturarUsuario(request, response);
		usuario = usuarioDao.buscarPorEmail(usuario);
		try {
			SendMail email = new SendMail();
			email.send(usuario.getEmail(), usuario.getSenha());
		} catch (Exception e) {
			request.setAttribute("mensagemErro", "Não foi possível encontrar o e-mail informado :(");
		}
		request.setAttribute("mensagemSucesso", "Sua senha foi enviada por e-mail");
		request.setAttribute("lembrete", usuario.getLembrete());
		encaminharRequisicao(request, response, "usuario-recuperar.jsp");
	}	
	
	private void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioForm = capturarUsuario(request, response);
		Usuario usuarioBanco = usuarioDao.buscarPorEmail(usuarioForm);
		String destino = "";
		
		String senhaCriptografada = "";
				
		try {
			senhaCriptografada = Criptografia.criptografar(usuarioForm.getSenha());
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		
		if (senhaCriptografada.equals(usuarioBanco.getSenha())) {
			request.getSession().setAttribute("usuario", usuarioBanco);
			request.setAttribute("mensagemSucesso", "Login efetuado com sucesso");
			destino = "index";
		} else {
			request.setAttribute("mensagemErro", "E-mail ou senha inválidos");
			destino = "login.jsp";
		}
		encaminharRequisicao(request, response, destino);
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = capturarUsuario(request, response);
		try {
			usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		usuarioDao.salvar(usuario);
		usuario = usuarioDao.buscarPorEmail(usuario);
		request.getSession().setAttribute("usuario", usuario);
		request.setAttribute("mensagem", "Usuario cadastrado com sucesso");
		encaminharRequisicao(request, response, "index");
	}
	
	private Usuario capturarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("nome"));
		u.setEmail(request.getParameter("email"));
		u.setSenha(request.getParameter("senha"));
		u.setLembrete(request.getParameter("lembrete"));
		return u;
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String caminho) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(caminho);
		rd.forward(request, response);
	}
}
