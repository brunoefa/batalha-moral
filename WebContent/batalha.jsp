<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Batalha" name="titulo"/>
</jsp:include>
		<div class="col-sm-6 candidato-left margin-top5">
        	<img src="img/barack.jpg" class="img-responsive small-profile img-circle" alt="">
        	<h2 class="padding-top2">Barack Obama</h2>
        	
        	<p>Candidato a <b>Prefeito</b> de <b>Belo Horizonte</b> pelo <b>PT</b> <span class="label label-default">13</span></p>
        	
        	<a href="#" class="btn btn-default btn-lg margin-top1 margin-bottom1">Meu Voto</a>
        	
        </div>
        
        <div class="col-sm-6 candidato-right margin-top5" >
        	<img src="img/barack.jpg" class="img-responsive small-profile img-circle" alt="">
        	<h2 class="padding-top2">Barack Obama</h2>
        	
        	<p><span class="label label-default">13</span> Candidato a <b>Prefeito</b> de <b>Belo Horizonte</b> pelo <b>PT</b></p>
        	
        	<a href="#" class="btn btn-default btn-lg margin-top1 margin-bottom1">Meu Voto</a>
        </div>

		<div class="col-sm-12 text-center margin-top5">
			<a href="#" class="btn btn-lg btn-primary">
                 <i class="fa fa-plus"></i> Cadastrar novo candidato
             </a>
		</div>


<jsp:include page="rodape.jsp"></jsp:include>