<%-- 
    Document   : cadastrousuario
    Created on : 03/10/2016, 19:29:51
    Author     : Gilberto
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

<h1>Adicionar Nova Categoria</h1>

<c:if test="${categoria == null}">
    <form action="forumcontroller.do?acao=novacategoria" method="POST">
        <label>NOME DA CATEGORIA</label>
        <div class="input-control textarea full-size">
            <input type="text" value="${categoria.nome}"  required size="150" name="categoria"/>
        </div>
        <button class="button success" type="submit">Salvar</button>
        <button class="button danger" type="button" onclick="history.back();">Cancelar</button>
    </form>
</c:if>

<c:if test="${categoria != null}">
    <form action="forumcontroller.do?acao=editarcategoria&id=${categoria.id}" method="POST">
        <label>NOME DA CATEGORIA</label>
        <div class="input-control textarea full-size">
            <input type="text" value="${categoria.nome}"  required size="150" name="categoria"/>
        </div>

        <input type="text" value="${categoria.nome}"  required size="50" name="categoria"/>

        <button class="button success" type="submit">Salvar</button>
        <button class="button danger" type="button" onclick="history.back();">Cancelar</button>
    </form>
</c:if>

<%@include file="fragment/foot.jsp" %>