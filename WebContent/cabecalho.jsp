<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="meta.jsp">
	<jsp:param value="${param.titulo}" name="titulo" />
</jsp:include>

<jsp:include page="menu.jsp"></jsp:include>
    <section id="portfolio">
		<!-- <div class="alert alert-success"><b>\o/</b> ${mensagem}</div> -->
        <div class="container margin-top3">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>${param.titulo}</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">