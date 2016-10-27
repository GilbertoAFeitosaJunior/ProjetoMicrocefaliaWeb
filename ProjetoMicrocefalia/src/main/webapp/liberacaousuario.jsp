<%-- 
    Document   : liberacaousuario
    Created on : 22/10/2016, 11:07:21
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liberação de Usuário</title>
    </head>
    <body>


        <h1>Lista de Usuários</h1>
    <div style="position: absolute;left: 10%">
        <table cellpadding="5" border="1px">
            <tr>
                <th>CÓDIGO</th>
                <th>NOME</th>
                <th>E-MAIL</th>
                <th>LOGIN</th>
                <th>AUTENTICAÇÃO</th>
                <th>DATA DO CADASTRO</th>
                <th>OPÇAO DO SISTEMA</th>
            </tr>
            <c:forEach var="usuario" items="${requestScope.usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.login}</td>
                    <td>${usuario.permissao}</td>
                    <td>${usuario.dataDoCadastro}</td>
                    <td>
                        <a href="#">LIBERAR</a>
                        |
                        <a href="#">DESABILITAR</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
