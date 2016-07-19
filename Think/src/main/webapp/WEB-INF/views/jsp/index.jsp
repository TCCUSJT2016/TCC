<%@ page session="false"%>

<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form" 	%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"		%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt" 	%>


  <!DOCTYPE html>
  <html>
  <head>
	<link href="<c:url value="/resources/css/teste.css" />" rel="stylesheet">

  <title>Spring MVC</title>
  </head>
  <body>
      <h1>Olá!</h1>
      <P>${mensagemTeste}</P>
      <form action="cadastrarEmpresa" method="post">
      	<button>Cadastrar Empresa</button>
      </form>
      <form action="consultarEmpresa" method="post">
      	<button>Consultar Empresa</button>
      </form>
      <form action="testeConexao" method="post">
      	<button>Teste conexão</button>
      </form>
  </body>
  </html>