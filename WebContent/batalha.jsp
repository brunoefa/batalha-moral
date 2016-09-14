<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Batalha" name="titulo"/>
</jsp:include>

       	<form action="batalha" id="batalha" method="post">
      		<input type="hidden" name="acao" value="salvar">
      		<input type="hidden" id="inputC1" name="candidato1" value="${batalha.candidato1.id}">
      		<input type="hidden" id="inputC2" name="candidato2" value="${batalha.candidato2.id}">
      		<input id="vencedor" type="hidden" name="vencedor" value="">


			<div class="col-sm-6 candidato-left margin-top5">
	        	<img src="${batalha.candidato1.url}" class="img-responsive small-profile img-circle" alt="">
	        	<h2 class="padding-top2">${batalha.candidato1.nome}</h2>
	        	
	        	<p>Candidato a <b>${batalha.candidato1.cargo}</b> de <b>${batalha.candidato1.cidade}</b> pelo <b>${batalha.candidato1.partido}</b> <span class="label label-default">${batalha.candidato1.numero}</span></p>
	       		<button type="button" id="btnC1" class="btn btn-default btn-lg margin-top1 margin-bottom1">Meu voto</button>
	        </div>
	        
	        <div class="col-sm-6 candidato-right margin-top5" >
	        	<img src="${batalha.candidato2.url}" class="img-responsive small-profile img-circle" alt="">
	        	<h2 class="padding-top2">${batalha.candidato2.nome}</h2>
	        	<p><span class="label label-default">${batalha.candidato2.numero}</span> Candidato a <b>${batalha.candidato2.cargo}</b> de <b>${batalha.candidato2.cidade}</b> pelo <b>${batalha.candidato2.partido}</b></p>
	       		<button type="button" id="btnC2" class="btn btn-default btn-lg margin-top1 margin-bottom1">Meu voto</button>
	        </div>
	
			<div class="col-sm-12 text-center margin-top5">
				<c:if test="${not empty captcha}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Oooops!</strong> ${captcha}
				</div>
				</c:if>
				<div class="confirmation g-recaptcha" data-sitekey="6Lc7_SkTAAAAAK57Ytnj1kP2ctWq_XTczU6aXEUo"></div>
			</div>

		</form>

<jsp:include page="rodape.jsp"></jsp:include>