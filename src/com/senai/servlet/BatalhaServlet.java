package com.senai.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senai.dao.BatalhaDao;
import com.senai.dao.CandidatoDao;
import com.senai.model.Batalha;
import com.senai.model.Candidato;
import com.senai.util.ReCaptchaImpl;
import com.senai.util.ReCaptchaResponse;

/**
 * Servlet implementation class BatalhaServlet
 */
@WebServlet("/batalha")
public class BatalhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BatalhaDao batalhaDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatalhaServlet() {
        super();
        batalhaDao = new BatalhaDao();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if ("salvar".equals(acao)) {
			salvar(request, response);
		} else {
			gerar(request, response);
		}
	}
	
	private void gerar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Batalha batalha = batalhaDao.gerarBatalha();
		request.setAttribute("batalha", batalha);
		encaminharRequisicao(request, response, "batalha.jsp");
	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Batalha b = capturarBatalha(request, response);
		if (verificaCaptcha(request, response)) {
			batalhaDao.salvar(b);
			request.setAttribute("mensagem", "Batalha salva com sucesso");
			gerar(request, response);
		} else {
			request.setAttribute("captcha", "Por favor responda a verificação humana antes de votar");
			request.setAttribute("batalha", b);
			encaminharRequisicao(request, response, "batalha.jsp");
		}
	}
	
	private Boolean verificaCaptcha(HttpServletRequest request, HttpServletResponse response) {
		ReCaptchaImpl reCaptcha  = new ReCaptchaImpl("6Lc7_SkTAAAAAK57Ytnj1kP2ctWq_XTczU6aXEUo","6Lc7_SkTAAAAAKBoxVeJTvaEAvgmok-5WplJ27p4");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.verifyResponse(request.getParameter("g-recaptcha-response"), null);
		return reCaptchaResponse.isSuccess();
	}

	private Batalha capturarBatalha(HttpServletRequest request, HttpServletResponse response) {
		Batalha b = new Batalha();
		
		CandidatoDao candidatoDao = new CandidatoDao();
		
		Candidato c1 = preencherCandidato(request.getParameter("candidato1"));
		c1 = candidatoDao.buscarPorId(c1);
		b.setCandidato1(c1);
		
		Candidato c2 = preencherCandidato(request.getParameter("candidato2"));
		c2 = candidatoDao.buscarPorId(c2);
		b.setCandidato2(c2);

		Candidato v = preencherCandidato(request.getParameter("vencedor"));
		b.setVencedor(v);

		return b;
	}
	
	private Candidato preencherCandidato(String id) {
		Candidato c = new Candidato();
		if (id != null && !"".equals(id)) {
			Integer intId = Integer.parseInt(id);
			c.setId(intId);
		}
		return c;
	}

	private void encaminharRequisicao(HttpServletRequest request, HttpServletResponse response, String caminho) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(caminho);
		rd.forward(request, response);
	}
	
	
	
}
