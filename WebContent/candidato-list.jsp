<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Candidatos cadastrados" name="titulo"/>
</jsp:include>

	<a href="candidato" class="btn btn-success btn-lg float-right">Cadastrar novo candidato</a>

	<c:forEach items="${listaCandidatos}" var="candidato">

       <div class="row col-xs-12 bottom-divisor">
         <div class="col-sm-2">
         	<img src="${candidato.url}" class="img-responsive mini-profile img-circle" alt="">
      	 </div>
      	 <div class="col-sm-10 padding-top1">
         	<h2>${candidato.nome}</h2>
         	<p><span class="label label-default">${candidato.numero}</span> Candidato a <b>${candidato.cargo}</b> em <b>${candidato.cidade}</b> pelo partido <b>${candidato.partido}</b></p>
         	<a href="candidato?acao=excluir&id=${candidato.id}" alt="Excluir"><i class="fa fa-trash icon-list"></i></a> 
         	<a href="candidato?acao=editar&id=${candidato.id}" alt="Editar"><i class="fa fa-pencil icon-list"></i></a>
      	 </div>
       </div>  
               
    </c:forEach>            

<jsp:include page="rodape.jsp"></jsp:include>







