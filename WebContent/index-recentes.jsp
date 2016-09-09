<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Portfolio Grid Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Últimos candidatos cadastrados</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
            	
				<c:forEach items="${ultimosCadastrados}" var="candidato">            	
            	
            	<div class="col-sm-4 portfolio-item">
                    <img src="${candidato.url}" class="img-responsive small-profile img-circle" alt="">
                </div>
                
                </c:forEach>

                <div class="col-lg-8 col-lg-offset-2 text-center margin-top5">
                    <a href="#" class="btn btn-lg btn-primary">
                        <i class="fa fa-play"></i> Comece a jogar agora
                    </a>
                </div>                
                
            </div>
        </div>
    </section>
