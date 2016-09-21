<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Recuperar Senha" name="titulo"/>
</jsp:include>

	<form name="usuario" id="contactForm" action="usuario" method="post">
		<input type="hidden" name="acao" value="recuperar">

       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>E-mail</label>
               <input type="text" name="email" class="form-control" placeholder="E-mail" id="email" required data-validation-required-message="Informe o e-mail">
               <p class="help-block text-danger"></p>
           </div>
       </div>

       <br>
           <p><a href="usuario">Voltar para o login</a></p>
       <br>
       
       <div id="success"></div>
       <div class="row">
           <div class="form-group col-xs-12">
               <button type="submit" class="btn btn-success btn-lg">Recuperar senha</button>&nbsp;
               <a href="/bm" class="btn btn-default btn-lg">Cancelar</a>
           </div>
       </div>
   </form>              	

<jsp:include page="rodape.jsp"></jsp:include>