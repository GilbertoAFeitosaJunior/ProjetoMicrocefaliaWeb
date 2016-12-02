<%-- 
    Document   : criarnoticiais
    Created on : 04/11/2016, 15:59:57
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

<h1>Adicionar nova notícia</h1>
<form action="noticiacontroller.do?acao=adicionarNoticia" method="POST" accept-charset="utf-8">

    <label>Foto da notícia</label>
    <div class="input-control text full-size">
        <input type="text" placeholder="LINK DA FOTO DA NOTÍCIA" required size="150" name="fotoNoticia"/>
    </div>      
    </br>
    </br>
    <label>Título</label>
    <div class="input-control text full-size">
        <input type="text" placeholder="TITULO DA NOTICIA"  required size="100" name="tituloNoticia"/>
    </div>
    </br>
    </br>
    <label>Chamada</label>
    <div class="input-control text full-size">
        <input type="text" placeholder="CHAMADA DA NOTÍCIA"  required size="150" name="chamadaNoticia"/>
    </div>
    </br>
    </br>
    <label>Fonte</label>
    <div class="input-control text full-size">
        <input type="text" placeholder="FONTE DA NOTÍCIA" required size="150" name="fonteNoticia" />
    </div>
    </br>
    </br>
    <label>Data da notícia</label>
    <div class="input-control text full-size" data-role="datepicker" data-format="dd/mm/yyyy">
        <input type="text" readonly="true" placeholder="DATA DA NOTÍCIA"  required size="150" name="dataNoticia" id="dataNoticia" />
        <button class="button"><span class="mif-calendar"></span></button>
    </div>
    </br>
    </br>
     <label>Notícia</label>
    <div class="input-control textarea full-size">
        <textarea rows="10" required  name="conteudoNoticia" ></textarea>
    </div>

    <br/><br/>
    <button class="button success" type="submit">Salvar</button>
    <button class="button danger" type="button" onclick="history.back();">Cancelar</button>
</form>

<%@include file="fragment/foot.jsp" %>