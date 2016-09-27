<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="/bm">Batalha Moral</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="candidato?acao=listar">Candidatos</a>
                    </li>
                    <li class="page-scroll">
                        <a href="batalha">Batalha</a>
                    </li>
                    <li class="page-scroll">
                        <a href="candidato?acao=relatorio-geral">Parcial</a>
                    </li>
                    
                    <c:if test="${empty sessionScope.usuario}">
                    <li class="page-scroll">
                        <a href="usuario">Entrar</a>
                    </li>
                    </c:if>
                    
                    <c:if test="${not empty sessionScope.usuario}">
                    <li class="page-scroll">
                        <span>${sessionScope.usuario.primeiroNome} <a href="usuario?acao=sair">(Sair)</a></span>
                    </li>
                    </c:if>
                                        
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>   
