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
        <title>Lista de Usuários Android</title>
    </head>
    <body>

        <a href="welcome.jsp">Home</a>

        <h1>Lista de Usuários</h1>
        <div style="position: absolute;left: 10%">
            <table cellpadding="5" border="1px">
                <tr>
                    <th>CÓDIGO</th>
                    <th>NOME</th>
                    <th>E-MAIL</th>
                    <th>ESTADO</th>
                    <th>PERFIL</th>
                </tr>
                <c:forEach var="usuario" items="${requestScope.usuariosAndroid}">
                    <c:if test="${usuario.nome != 'admin'}">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.nome}</td>
                            <td>${usuario.email}</td>
                            <td>${usuario.estado}</td>
                            <td>
                                <a href = "usuandroidcontroller.do?acao=exibirperfil&id=${usuario.id}"> VISUALIZAR </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
