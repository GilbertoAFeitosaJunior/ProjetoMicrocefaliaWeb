<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibir Usuário</title>
    </head>
    <body>

        <a href="forum.jsp">VOLTAR</a>
        <h1>Categorias</h1>
        <a href="criarcategoria.jsp">Criar Nova Categoria</a> 
        </br>
        </br>       
        <table cellpadding="5" border="1px">
            <tr>
                <th>CÓDIGO</th>
                <th>NOME</th>
                <th>DATA</th>
                <th>USUARIO</th>
                <th>OPÇÃO</th>
            </tr>
            <c:forEach var="categoria" items="${requestScope.listaCategoria}">
                <tr>
                    <td>${categoria.id}</td>
                    <td>${categoria.nome}</td>
                    <td>${categoria.data}</td>
                    <td>${categoria.moderador.usuarioPainel.nome}</td>  
                    <td><a href="forumcontroller.do?acao=editarcategoria&id=${categoria.id}">EDITAR</a></td>

                </c:forEach>
        </table>
    </body>  


</html>
