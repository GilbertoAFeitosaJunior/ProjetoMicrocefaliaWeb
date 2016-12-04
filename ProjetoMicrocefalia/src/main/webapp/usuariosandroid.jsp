<%-- 
    Document   : liberacaousuario
    Created on : 22/10/2016, 11:07:21
    Author     : Gilberto
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

<h1 class="text-light">USUÁRIOS ANDROID</h1>
<hr class="thin bg-grayLighter">
<hr class="thin bg-grayLighter">

<table class="dataTable border hovered  bordered" data-role="datatable" data-auto-width="false">
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
                    <a href = "usuandroidcontroller.do?acao=exibirperfil&id=${usuario.id}">
                        <span class="mif-eye"></span
                    </a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<%@include file="fragment/foot.jsp" %>
