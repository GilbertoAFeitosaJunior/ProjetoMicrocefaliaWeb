<%-- 
    Document   : cadastrousuario
    Created on : 03/10/2016, 19:29:51
    Author     : Gilberto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Categoria</title>
    </head>
    <body>
        <a href="forumcontroller.do?acao=listar_categoria">VOLTAR</a>
        <h1>NOVA CATEGORIA</h1>
        <c:if test="${categoria == null}">
            <form action="forumcontroller.do?acao=novacategoria" method="POST">
                <input type="text" placeholder="Nome da Categoria"  required size="50" name="categoria"/>
                <button type="submit">Enviar</button>
            </form>
        </c:if>
        
        <c:if test="${categoria != null}">
            <form action="forumcontroller.do?acao=editarcategoria&id=${categoria.id}" method="POST">
                <input type="text" value="${categoria.nome}"  required size="50" name="categoria"/>
                <button type="submit">Enviar</button>
            </form>
        </c:if>

    </body>
</html>
