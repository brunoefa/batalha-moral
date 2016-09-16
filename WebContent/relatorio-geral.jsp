<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Parcial de votos" name="titulo"/>
</jsp:include>
	<jsp:useBean id="random" class="java.util.Random" scope="application" />
	
	<c:forEach items="${listaCandidatos}" var="candidato">

       <div class="row col-xs-12 bottom-divisor">
         <div class="col-sm-2">
         	<img src="${candidato.url}" class="img-responsive mini-profile img-circle" alt="">
      	 </div>
      	 <div class="col-sm-10 padding-top1">
         	<h2>${candidato.nome}</h2>
         	<p><span class="label label-default">${candidato.votos} Votos</span> Candidato a <b>${candidato.cargo}</b> em <b>${candidato.cidade}</b> pelo partido <b>${candidato.partido}</b> - Número <b>${candidato.numero}</b></p>
         	<div class="progress">
         	
         	  <c:set var="percentual" value="${candidato.votos * 100 / totalDeBatalhas}" />
         	
			  <div class="progress-bar progress-bar-${random.nextInt(9)}" role="progressbar" aria-valuenow="${candidato.votos}" aria-valuemin="0" aria-valuemax="${totalDeBatalhas}" style="width: ${percentual}%">
			    <fmt:formatNumber value="${percentual}" maxFractionDigits="0" />%
			  </div>
			  
			</div>
      	 </div>
       </div>   
               
    </c:forEach>            

<jsp:include page="rodape.jsp"></jsp:include>







