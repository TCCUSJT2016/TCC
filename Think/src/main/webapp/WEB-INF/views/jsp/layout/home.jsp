<%@ page session="false"%>

<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form" 	%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"		%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt" 	%>

<%@page import="com.projeto.think.Model.Desafio" %>

<%@page import="javax.servlet.http.HttpSession" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>Think</title>

	<link href="<c:url value="/resources/stylesheets/vendors.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/stylesheets/think.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/stylesheets/application.css" />" rel="stylesheet">
	
</head>
<body>

<div class="aw-layout-page">
	
	<nav class="navbar  navbar-fixed-top  navbar-default  js-sticky-reference" id="main-navbar">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand  hidden-xs" href="#">
	        <!-- <img alt="Think" src="<c:url value="/resources/images/logo2.png"/>">  -->
	      </a>
	      <ul class="nav  navbar-nav">
	        <li>
	          <a href="#" class="js-sidebar-toggle"><i class="fa  fa-bars"></i></a>
	        </li>
	      </ul>
	    </div>
	    <ul class="nav navbar-nav  navbar-right">	      
	      <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
	          <i class="fa  fa-user"></i>
	        </a>
	        <ul class="dropdown-menu">
	          <li>
	            <div class="aw-logged-user">
	              <img src="https://api.adorable.io/avatars/80/joaodascouves" 
	                width="80" height="80" alt="" class="aw-logged-user__picture" />
	              <span class="aw-logged-user__name">Eduardo Tadeu</span>
	            </div>
	          </li>
	          <li role="separator" class="divider"></li>
	          <li><a href="#">Meu perfil</a></li>
	          <li><a href="#">Alterar senha</a></li>
	        </ul>
	      </li>
	      <li>
	        <a href="#"><em class="fa  fa-sign-out"></em></a>
	      </li> 
	    </ul>
	  </div>
	</nav>
	
	<aside class="aw-layout-sidebar  js-sidebar">
		<div class="aw-layout-sidebar__content">
	    	<nav class="aw-menu  js-menu">
	    		<ul class="aw-menu__list">
	        		<li class="aw-menu__item">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<i class="fa  fa-fw  fa-plus-circle"></i>Empresa</a>
          				<ul class="dropdown-menu">
          					<li><a href="#">Cadastrar</a></li>
          					<li><a href="#">Consultar</a></li>
          				</ul>
	        		</li>
	        		<li class="aw-menu__item">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<i class="fa  fa-fw  fa-plus-circle"></i>Candidato</a>
          				<ul class="dropdown-menu">
          					<li><a href="#">Cadastrar</a></li>
          					<li><a href="#">Consultar</a></li>
          				</ul>
	        		</li>
	        		<li class="aw-menu__item">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<i class="fa  fa-fw  fa-plus-circle"></i>Pontuação</a>
          				<ul class="dropdown-menu">
          					<li><a href="#">Consultar</a></li>
          				</ul>
	        		</li>
	        		<li class="aw-menu__item">
          				<a data-toggle="modal" href="#aceitaDesafio">
          					<i class="fa  fa-fw  fa-plus-circle"></i>
          					<span>Desafio</span><span class="label  label-danger  aw-label-corner">1</span>
          				</a>
	        		</li>
	        	</ul>
	    	</nav>
		</div>
	</aside>

	<!-- CONTEUDO DAS PAGINAS -->
	<div class="modal fade" tabindex="-1" role="dialog" id="aceitaDesafio">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">Mensagem de confirmação!</h4>
	      </div>
	      <div class="modal-body">
	        <p>Você deseja aceitar este desafio?</p>
	      </div>
	      <div class="modal-footer">
	        <a type="button" class="btn btn-default" data-dismiss="modal">Não</a>
	        <a href="./desafio/realizar.do" type="submit" class="btn btn-primary">Sim</a>
	      </div>
	    </div>
	  </div>
	</div>

	<footer class="aw-layout-footer  js-content">
 		<div class="container-fluid">
 			<span class="aw-footer-disclaimer">&copy; 2016 Think. Todos os direitos reservados.</span>
 		</div>
	</footer>
</div>
<script src="<c:url value="/resources/javascripts/vendors.min.js"/>"> </script>
<script src="<c:url value="/resources/javascripts/think.min.js"/>"> </script>
</body>
</html>