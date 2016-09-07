<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Cadastro de Candidato" name="titulo"/>
</jsp:include>

	<form name="candidato" id="contactForm" action="candidato" method="post">
		<input type="hidden" name="acao" value="salvar">
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Nome</label>
               <input type="text" name="nome" class="form-control" placeholder="Nome" id="name" required data-validation-required-message="Informe o nome do candidato">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Cargo</label>
               <input type="text" name="cargo" class="form-control" placeholder="Cargo" id="cargo" required data-validation-required-message="Informe o cargo">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Foto</label>
               <input type="text" name="url" class="form-control" placeholder="Url da imagem" id="url" required data-validation-required-message="Inclua a url da foto">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Cidade</label>
               <input type="text" name="cidade" class="form-control" placeholder="Cidade" id="cidade" required data-validation-required-message="Informe a cidade">
               <p class="help-block text-danger"></p>
           </div>
       </div>                    
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Partido</label>
               <input type="text" name="partido" class="form-control" placeholder="Partido" id="partido" required data-validation-required-message="Informe o partido">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Número</label>
               <input type="text" name="numero" class="form-control" placeholder="Número" id="numero" required data-validation-required-message="Informe o número">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <br>
       <div id="success"></div>
       <div class="row">
           <div class="form-group col-xs-12">
               <button type="submit" class="btn btn-success btn-lg">Salvar Candidato</button>&nbsp;
               <a href="candidato?acao=listar" class="btn btn-default btn-lg">Cancelar</a>
           </div>
       </div>
   </form>              	

<jsp:include page="rodape.jsp"></jsp:include>