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
		} else if ("sair".equals(acao)) {
			sair(request, response);
		} else if ("salvar".equals(acao)) {
			salvar(request, response);
		} else if ("esqueci".equals(acao)) {
			esqueci(request, response);
		} else if ("recuperar".equals(acao)) {
			recuperar(request, response);
		} else if ("redefinir".equals(acao)) {
			redefinir(request, response);
		} else if ("atualizarSenha".equals(acao)) {
			atualizarSenha(request, response);
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

	private void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		encaminharRequisicao(request, response, "index");
	}
	
	private void redefinir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = capturarUsuario(request, response);
		request.setAttribute("usuario", usuario);
		encaminharRequisicao(request, response, "usuario-redefinir.jsp");
	}
	
	private void atualizarSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioForm = capturarUsuario(request, response);
		Usuario usuarioBanco = usuarioDao.buscarPorId(usuarioForm);
		String destino = "usuario-redefinir.jsp"; 
		
		if (!usuarioForm.getRecuperacao().equals(usuarioBanco.getRecuperacao())) {
			request.setAttribute("mensagemErro", "Chave de recuperação de senha inválida");
			request.setAttribute("usuario", usuarioForm);
			destino = "usuario-redefinir.jsp";
		} else {
			String confirmacao = request.getParameter("confirmacao-senha");
			if (!usuarioForm.getSenha().equals(confirmacao)) {
				request.setAttribute("mensagemErro", "A confirmação de senha não corresponde a senha informada");
				request.setAttribute("usuario", usuarioForm);
				destino = "usuario-redefinir.jsp";
			} else {
				try {
					usuarioBanco.setSenha(Criptografia.criptografar(usuarioForm.getSenha()));
					usuarioDao.atualizarSenha(usuarioBanco);
					request.setAttribute("mensagemSucesso", "Senha redefinida com sucesso");
					destino = "login.jsp";
				} catch (NoSuchAlgorithmException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		encaminharRequisicao(request, response, destino);
	}

	
	private void recuperar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = capturarUsuario(request, response);
		usuario = usuarioDao.buscarPorEmail(usuario);
		try {
			SendMail email = new SendMail();
			gerarChaveDeRecuperacaoDeSenha(usuario);
			email.send(usuario.getEmail(), usuario);
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
	
	private Usuario gerarChaveDeRecuperacaoDeSenha(Usuario usuario) throws ServletException, IOException {
		Integer randomNum = 1000 + (int)(Math.random() * 10000);
		String recuperacao = String.valueOf(usuario.getId()) + String.valueOf(randomNum);
		usuario.setRecuperacao(recuperacao);
		usuarioDao.atualizarRecuperacao(usuario);
		return usuario;
	}
	
	private Usuario capturarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		
		String sId = request.getParameter("id");
		if (sId != null && !"".equals(sId)) {
			int id = Integer.parseInt(sId);
			System.out.println("Id: " + id);
			u.setId(id);
		}
		u.setNome(request.getParameter("nome"));
		u.setEmail(request.getParameter("email"));
		u.setSenha(request.getParameter("senha"));
		u.setLembrete(request.getParameter("lembrete"));
		u.setRecuperacao(request.getParameter("recuperacao"));
		return u;
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String caminho) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(caminho);
		rd.forward(request, response);
	}
}
