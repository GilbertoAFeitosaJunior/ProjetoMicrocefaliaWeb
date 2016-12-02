<%-- 
    Document   : criarnoticiais
    Created on : 04/11/2016, 15:59:57
    Author     : Gilberto
--%>
<%@include file="fragment/auth.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="fragment/head.jsp" %>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
<script type="text/javascript" src="https://raw.githubusercontent.com/digitalBush/jquery.maskedinput/1.4.1/dist/jquery.maskedinput.min.js"></script>
<script type="text/javascript">
    $(function ($) {
        $("#dataNoticia").mask("99/99/9999", {placeholder: "mm/dd/yyyy"});
    });
</script>


<h1 class="text-light">Editar Notícia</h1>
<hr class="thin bg-grayLighter">

<form action="noticiacontroller.do?acao=editarnoticia" method="POST">

    <input type="hidden" value="${requestScope.noticia.id}" readonly="readonly" required size="150" name="idNoticia"/>

    <label>Foto da notícia</label>
    <div class="input-control text full-size">
        <input type="text" value="${requestScope.noticia.foto}" required size="150" name="fotoNoticia"/>
    </div>

    <label>Título</label>
    <div class="input-control text full-size">
        <input type="text" value="${requestScope.noticia.titulo}" required size="150" name="tituloNoticia"/>
    </div>

    <label>Chamada</label>
    <div class="input-control text full-size">
        <input type="text" value="${requestScope.noticia.chamada}"  required size="150" name="chamadaNoticia"/>
    </div>

    <label>Fonte</label>
    <div class="input-control text full-size">
        <input type="text" value="${requestScope.noticia.fonte}" required size="150" name="fonteNoticia" />
    </div>

    <label>Data da notícia</label>
    <div class="input-control text full-size" data-role="datepicker" data-format="dd/mm/yyyy">
        <input type="text" readonly="true" value="${requestScope.noticia.dataString}"  required size="150" name="dataNoticia" id="dataNoticia" />
        <button class="button"><span class="mif-calendar"></span></button>
    </div>

    <label>Notícia</label>
    <div class="input-control textarea full-size">
        <textarea rows="10" required  name="conteudoNoticia" >${requestScope.noticia.noticia}</textarea>
    </div>

    <button class="button success" type="submit">Salvar</button>
    <button class="button danger" type="button" onclick="history.back();">Cancelar</button>
</form>


<%@include file="fragment/foot.jsp" %>