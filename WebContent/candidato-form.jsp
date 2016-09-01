<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp">
	<jsp:param value="Cadastro de Candidato" name="titulo"/>
</jsp:include>

	<form name="sentMessage" id="contactForm" novalidate>
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Nome</label>
               <input type="text" class="form-control" placeholder="Nome" id="name" required data-validation-required-message="Please enter your name.">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Cargo</label>
               <input type="text" class="form-control" placeholder="Cargo" id="cargo" required data-validation-required-message="Por favor informe o cargo">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Foto</label>
               <input type="text" class="form-control" placeholder="Url da imagem" id="phone" required data-validation-required-message="Inclua sua foto">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Cidade</label>
               <input type="text" class="form-control" placeholder="Cidade" id="cidade" required data-validation-required-message="Please enter your email address.">
               <p class="help-block text-danger"></p>
           </div>
       </div>                    
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Partido</label>
               <input type="text" class="form-control" placeholder="Partido" id="email" required data-validation-required-message="Please enter your email address.">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <div class="row control-group">
           <div class="form-group col-xs-12 floating-label-form-group controls">
               <label>Número</label>
               <input type="tel" class="form-control" placeholder="Número" id="phone" required data-validation-required-message="Please enter your phone number.">
               <p class="help-block text-danger"></p>
           </div>
       </div>
       <br>
       <div id="success"></div>
       <div class="row">
           <div class="form-group col-xs-12">
               <button type="submit" class="btn btn-success btn-lg">Salvar Candidato</button>&nbsp;
               <button type="button" class="btn btn-default btn-lg">Cancelar</button>
           </div>
       </div>
   </form>              	
                


<jsp:include page="rodape.jsp"></jsp:include>