package com.senai.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.dao.CandidatoDao;
import com.senai.model.Candidato;

/**
 * Servlet implementation class CandidatoServlet
 */
@WebServlet("/candidato")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CandidatoDao candidatoDao;

    public CandidatoServlet() {
    	candidatoDao = new CandidatoDao();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		if ("salvar".equals(acao)) {
			salvar(request, response);
		} else if ("editar".equals(acao)) {
			editar(request, response);
		} else if ("excluir".equals(acao)){
			excluir(request, response);
		} else if ("listar".equals(acao)) {
			listar(request, response);				
		} else {
			cadastrar(request, response);
		}
		
	}
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminharRequisicao(request, response, "candidato-form.jsp");
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato c = preencherCandidato(request, response);
		candidatoDao.salvar(c);
		request.setAttribute("mensagem", "Candidato salvo com sucesso");
		listar(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// capturar o ID
		// chamar o método buscarPorId da classe dao
		// colocar o candidato buscado como parametro na requicisao
		// encaminhar a requisicao para o candidato-form.jsp
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// capturar o ID
		// chamar o método excluir da classe dao
		// colocar uma mensagem de excluido com sucesso na requisicao
		// encaminhar a requisicao para o candidato-list.jsp
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidato> listaCandidatos = new ArrayList<Candidato>();
		listaCandidatos = candidatoDao.buscarTodos();
		request.setAttribute("listaCandidatos", listaCandidatos);
		encaminharRequisicao(request, response, "candidato-list.jsp");
	}
	
	private Candidato preencherCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato c = new Candidato();

		c.setNome(request.getParameter("nome"));
		c.setCargo(request.getParameter("cargo"));
		c.setUrl(request.getParameter("url"));
		c.setCidade(request.getParameter("cidade"));
		c.setPartido(request.getParameter("partido"));
		c.setNumero(request.getParameter("numero"));

		return c;
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String caminho) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(caminho);
		rd.forward(request, response);
	}
	
}
