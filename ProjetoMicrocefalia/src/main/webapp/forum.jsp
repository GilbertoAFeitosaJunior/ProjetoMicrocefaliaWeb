<%-- 
    Document   : wellcome
    Created on : 27/10/2016, 10:21:57
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Bem vindo ${sessionScope.usuLogado.nome}</h1>


        <ul>
            <li><a href="criarmoderador.jsp">Tornar-se Moderador</a></li>
            <li><a href="forumcontroller.do?acao=listar_categoria">Adicionar Nova Categoria</a></li>
            <li><a href="#">Tópicos em Aberto</a></li>
            <li><a href="#">Tópicos Fechados</li>
            <li><a href="welcome.jsp">Home</a></li>
         </ul>


    </body>
</html>
