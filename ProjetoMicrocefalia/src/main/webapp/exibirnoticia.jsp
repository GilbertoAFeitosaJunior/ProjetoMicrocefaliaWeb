<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

<img src="${requestScope.noticia.foto}" width="400" height="300" /> 
<h1>${requestScope.noticia.titulo}</h1>
<h2>${requestScope.noticia.chamada}</h2>
<p> </strong>${requestScope.noticia.noticia}</p>
<p>${requestScope.noticia.fonte}</p>
<p>${requestScope.noticia.data}</p>


<%@include file="fragment/foot.jsp" %>