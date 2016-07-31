<%--
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form" 	%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"		%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt" 	%>
--%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

		<meta name="mobile-web-app-capable" content="yes">

		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-title" content="Material Design Lite">

		<meta name="msapplication-TileImage" content="/resources/images/touch/ms-touch-icon-144x144-precomposed.png">
		<meta name="msapplication-TileColor" content="#3372DF">
		
		<script src="https://code.getmdl.io/1.1.3/material.min.js"></script>
		
		<link rel="stylesheet"	href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
		<link rel="stylesheet"	href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet"	href="https://code.getmdl.io/1.1.3/material.cyan-light_blue.min.css">
		<link rel='stylesheet' 	href='http://fonts.googleapis.com/css?family=Nunito:400,300' type='text/css'>

		<link rel="stylesheet" 						href="/resources/css/consultarEmpresa.css">
		<link rel="stylesheet"					 	href="/resources/css/styles.css">
		<link rel="icon" 							href="/resources/images/android-desktop.png" sizes="192x192">
		<link rel="apple-touch-icon-precomposed" 	href="/resources/images/ios-desktop.png">
		<link rel="shortcut icon" 					href="/resources/images/favicon.png">
		
		<style>
			#view-source {
				position: fixed;
				display: block;
				right: 0;
				bottom: 0;
				margin-right: 40px;
				margin-bottom: 40px;
				z-index: 900;
			}
			
			.demo-content {
				background: url('/resources/images/cloud-fundo.jpg') no-repeat #FFF;
				height: 1200px;
			}
		</style>
		
		<title>
			Cadastro de Empresa
		</title>
	</head>
	<body>
		<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
			<header	class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
				<div class="mdl-layout__header-row">
					<span class="mdl-layout-title">
						Consultar Empresas
					</span>
					<div class="mdl-layout-spacer"></div>
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable"></div>
				</div>
			</header>
			<div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
				<header class="demo-drawer-header">
					<img src="/resources/images/user.jpg" class="demo-avatar" />
					<div class="demo-avatar-dropdown">
						<span>
							user@example.com
						</span>
						<div class="mdl-layout-spacer"></div>
						<button id="opcoes"	class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
							<i class="material-icons" role="presentation">
								arrow_drop_down
							</i>
							<span class="visuallyhidden">
								Accounts
							</span>
						</button>
						<ul	class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="opcoes">
							<li class="mdl-menu__item">
								Configurações
							</li>
							<li class="mdl-menu__item">
								<a href="login.html">
									Sair
								</a>
							</li>
						</ul>
					</div>
				</header>
				<nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
					<a class="mdl-navigation__link" href="consultarEmpresa.jsp"><i
						class="mdl-color-text--blue-grey-400 material-icons"
						role="presentation">people</i>Empresas</a>
					<div class="mdl-layout-spacer"></div>
				</nav>
			</div>
			<main class="mdl-layout__content mdl-color--grey-100">
				<div class="mdl-grid demo-content">
					
					<!-- Aqui vai o conteudo da pagina -->
					<form action="" method="post">
						<h1>
							Consulte uma empresa pelo nome ou CNPJ
						</h1>
						<fieldset>
							<label for="name">
								Nome da Empresa:
							</label>
							<input type="text" id="name" name="emp_name"> 
							
							<label for="cnpj">
								CNPJ:
							</label>
							<input type="text" id="cnpj" name="emp_cnpj">
						</fieldset>
						<button type="submit">
							Consultar
						</button>
					</form>
				</div>
			</main>
		</div>
	</body>
</html>