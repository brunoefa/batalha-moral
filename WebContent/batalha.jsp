<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Batalha" name="titulo"/>
</jsp:include>
		<div class="col-sm-6 candidato-left margin-top5">
        	<img src="${batalha.candidato1.url}" class="img-responsive small-profile img-circle" alt="">
        	<h2 class="padding-top2">${batalha.candidato1.nome}</h2>
        	
        	<p>Candidato a <b>${batalha.candidato1.cargo}</b> de <b>${batalha.candidato1.cidade}</b> pelo <b>${batalha.candidato1.partido}</b> <span class="label label-default">${batalha.candidato1.numero}</span></p>
        	
        	<form action="batalha" method="post">
        		<input type="hidden" name="acao" value="salvar">
        		<input type="hidden" name="candidato1" value="${batalha.candidato1.id}">
        		<input type="hidden" name="candidato2" value="${batalha.candidato2.id}">
        		<input type="hidden" name="vencedor" value="${batalha.candidato1.id}">
        		<input type="submit" value="Meu Voto" class="btn btn-default btn-lg margin-top1 margin-bottom1">
        	</form>        	
        	
        </div>
        
        <div class="col-sm-6 candidato-right margin-top5" >
        	<img src="${batalha.candidato2.url}" class="img-responsive small-profile img-circle" alt="">
        	<h2 class="padding-top2">${batalha.candidato2.nome}</h2>
        	
        	<p><span class="label label-default">${batalha.candidato2.numero}</span> Candidato a <b>${batalha.candidato2.cargo}</b> de <b>${batalha.candidato2.cidade}</b> pelo <b>${batalha.candidato2.partido}</b></p>
        	
        	<form action="batalha" method="post">
        		<input type="hidden" name="acao" value="salvar">
        		<input type="hidden" name="candidato1" value="${batalha.candidato1.id}">
        		<input type="hidden" name="candidato2" value="${batalha.candidato2.id}">
        		<input type="hidden" name="vencedor" value="${batalha.candidato2.id}">
        		<input type="submit" value="Meu Voto" class="btn btn-default btn-lg margin-top1 margin-bottom1">
        		<div class="g-recaptcha" data-sitekey="6Lc6_SkTAAAAAOkcx4vPxxtbWCeZ_hyc4VEWcT1p"></div>
        	</form>
        </div>

		<div class="col-sm-12 text-center margin-top5">
			<a href="candidato" class="btn btn-lg btn-primary">
                 <i class="fa fa-plus"></i> Cadastrar novo candidato
             </a>
		</div>


<jsp:include page="rodape.jsp"></jsp:include>