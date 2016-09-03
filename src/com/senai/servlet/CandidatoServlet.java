package com.senai.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.model.Candidato;

/**
 * Servlet implementation class CandidatoServlet
 */
@WebServlet("/candidato")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		RequestDispatcher rd = request.getRequestDispatcher("candidato-form.jsp");
		rd.forward(request, response);
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidato c = preencherCandidato(request, response);
		System.out.println(c.getNome());
		System.out.println(c.getCargo());
		System.out.println(c.getUrl());
		System.out.println(c.getPartido());
		System.out.println(c.getCidade());
		System.out.println(c.getNumero());
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	
}
