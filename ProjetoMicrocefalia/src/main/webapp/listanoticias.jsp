<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
<a href="#" class="button success" ><span class="mif-play"></span> Categorias</a>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

<h1 class="text-light">Lista de Notícias</h1>
<hr class="thin bg-grayLighter">
<a href="criarnoticias.jsp" class="button primary"><span class="mif-plus"></span> Adicionar Nova...</a>
<hr class="thin bg-grayLighter">

<table class="dataTable border hovered  bordered" data-role="datatable" data-auto-width="false">
    <thead>
        <tr>
            <th>CÓDIGO</th>
            <th>TITULO</th>
            <th>DATA</th>
            <th>USUÁRIO</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="noticia" items="${requestScope.noticias}">
            <tr>
                <td>${noticia.id}</td>
                <td>${noticia.titulo}</td>
                <td>${noticia.dataString}</td>
                <td>${noticia.usuarioPainel.nome}</td>                       
                <td>
                    <a href ="noticiacontroller.do?acao=exibirnoticia&id=${noticia.id}"> 
                        <span class="mif-eye"></span>
                    </a>
                </td>
                <td>
                    <a href ="noticiacontroller.do?acao=editarnoticia&id=${noticia.id}"> 
                        <span class="mif-pencil"></span>
                    </a>
                </td>
                <td>
                    <a href ="javascript: excluir(${noticia.id})"> 
                        <span class="mif-bin"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script>
    function excluir(id) {
        if (confirm("Deseja Excluir?")) {
            window.location = "noticiacontroller.do?acao=deletarnoticia&id=" + id;
        }
    }
</script>

<%@include file="fragment/foot.jsp" %>