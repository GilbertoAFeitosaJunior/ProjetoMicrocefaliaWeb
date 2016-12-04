<%-- 
    Document   : liberacaousuario
    Created on : 22/10/2016, 11:07:21
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>
<h1>Lista de Usuários</h1>

<table class="dataTable border hovered  bordered" data-role="datatable" data-auto-width="false">
    <tr>
        <th>CÓDIGO</th>
        <th>NOME</th>
        <th>E-MAIL</th>
        <th>LOGIN</th>
        <th>AUTENTICAÇÃO</th>
        <th>DATA DO CADASTRO</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="usuario" items="${requestScope.usuarios}">
        <c:if test="${usuario.login != 'admin'}">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${usuario.login}</td>
                <td>${usuario.permissao}</td>
                <td>${usuario.dataDoCadastro}</td>
                <td>
                    <a href = "usuariocontroller.do?acao=habilitar&id=${usuario.id}">   
                        HABILITAR
                    </a>
                </td>
                
                <td>

                    <a href = "usuariocontroller.do?acao=desabilitar&id=${usuario.id}"> 
                        DESABILITAR
                    </a>

                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<%@include file="fragment/foot.jsp" %>