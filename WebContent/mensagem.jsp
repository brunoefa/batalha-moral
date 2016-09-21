<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty mensagemSucesso}">
	<div class="alert alert-success text-center">
		<b>\o/</b> ${mensagemSucesso}
	</div>
</c:if>
<c:if test="${not empty mensagemErro}">
	<div class="alert alert-danger text-center">
		<b>:( </b> ${mensagemErro}
	</div>
</c:if>
