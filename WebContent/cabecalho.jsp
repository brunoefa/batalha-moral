<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="meta.jsp">
	<jsp:param value="${param.titulo}" name="titulo" />
</jsp:include>

<jsp:include page="menu.jsp"></jsp:include>
    <section id="portfolio">
    	<jsp:include page="mensagem.jsp"></jsp:include>
        <div class="container margin-top3">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>${param.titulo}</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">