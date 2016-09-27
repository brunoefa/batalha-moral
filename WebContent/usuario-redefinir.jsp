<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Redefinir Senha" name="titulo"/>
</jsp:include>

	<form name="usuario" id="contactForm" action="usuario" method="post">
		<input type="hidden" name="acao" value="atualizarSenha">
		<input type="hidden" name="id" value="${usuario.id}">
		<input type="hidden" name="recuperacao" value="${usuario.recuperacao}">
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Senha</label>
               <input type="password" name="senha" class="form-control" placeholder="Sua senha" id="senha" required data-validation-required-message="Informe sua senha">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Confirmação de Senha</label>
               <input type="password" name="confirmacao-senha" class="form-control" placeholder="Confirme sua nova senha" id="senha" required data-validation-required-message="Repita sua senha">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <div class="row">
           <div class="form-group col-xs-12">
               <button type="submit" class="btn btn-success btn-lg">Salvar</button>&nbsp;
               <a href="/bm" class="btn btn-default btn-lg">Cancelar</a>
           </div>
       </div>
   </form>              	

<jsp:include page="rodape.jsp"></jsp:include>