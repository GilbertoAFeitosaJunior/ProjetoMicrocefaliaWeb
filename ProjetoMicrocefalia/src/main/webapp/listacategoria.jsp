<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

<h1 class="text-light">Lista de Notícias</h1>
<hr class="thin bg-grayLighter">
<a href="criarcategoria.jsp" class="button primary"><span class="mif-plus"></span> Criar Nova Categoria...</a>
<a href="criarmoderador.jsp" class="button primary"><span class="mif-android"></span> Tornar-se Moderador...</a>
<a href="#" class="button primary"><span class="mif-folder-open"></span> Tópicos em Aberto</a>
<a href="#" class="button primary"><span class="mif-folder"></span> Tópicos Fechados</a>

<hr class="thin bg-grayLighter">


<table class="dataTable border hovered  bordered" data-role="datatable" data-auto-width="false">
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
            <td><a href="forumcontroller.do?acao=editarcategoria&id=${categoria.id}"><span class="mif-pencil"></span></a></td>

        </c:forEach>
</table>
<%@include file="fragment/foot.jsp" %>