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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CandidatoDao candidatoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        candidatoDao = new CandidatoDao();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		buscarUltimosCadastrados(request, response);
		encaminharRequisicao(request, response, "index.jsp");
	}
	
	private void buscarUltimosCadastrados (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidato> ultimosCadastrados = candidatoDao.buscarUltimosCadastrados();
		request.setAttribute("ultimosCadastrados", ultimosCadastrados);
	}
	
	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String caminho) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(caminho);
		rd.forward(request, response);
	}

}
