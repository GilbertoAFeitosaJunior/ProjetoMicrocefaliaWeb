<%-- 
    Document   : wellcome
    Created on : 27/10/2016, 10:21:57
    Author     : Gilberto
--%>

<%--
    response.sendRedirect("noticiacontroller.do?acao=listaNoticia");

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        
    </head>
    <body>
        <h1>Bem vindo ${sessionScope.usuLogado.nome}</h1>


        <ul>
            <li><a href="criarnoticias.jsp">Adicionar Nova N�ticia</a></li>
            <li><a href="noticiacontroller.do?acao=listaNoticia">Lista de Not�cias</a></li>
            <li><a href="usuariocontroller.do?acao=listaUsuario">Liberar Usuario Web</a></li>
            <li><a href="usuandroidcontroller.do?acao=listar">Usuarios Android</a></li>
            <li><a href="forum.jsp">F�rum</a></li>
            <li><a href="autenticador.do">Sair do Sistema</a></li>

        </ul>


    </body>
</html>
--%>
