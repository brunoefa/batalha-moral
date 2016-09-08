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
		Candidato c = capturarCandidato(request, response);
		
		if (c.getId() == null) {
			candidatoDao.salvar(c);
		} else {
			candidatoDao.atualizar(c);
		}
		
		request.setAttribute("mensagem", "Candidato salvo com sucesso");
		listar(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato c = capturarCandidato(request, response);
		c = candidatoDao.buscarPorId(c);
		request.setAttribute("candidato", c);
		encaminharRequisicao(request, response, "candidato-form.jsp");
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato c = capturarCandidato(request, response);
		candidatoDao.excluir(c);
		request.setAttribute("mensagem", "Candidato excluído com sucesso");
		listar(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidato> listaCandidatos = new ArrayList<Candidato>();
		listaCandidatos = candidatoDao.buscarTodos();
		request.setAttribute("listaCandidatos", listaCandidatos);
		encaminharRequisicao(request, response, "candidato-list.jsp");
	}
	
	private Candidato capturarCandidato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato c = new Candidato();

		String sId = request.getParameter("id");
		if (sId != null && !"".equals(sId)) {
			Integer id = Integer.parseInt(sId);
			c.setId(id);
		}
		
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
