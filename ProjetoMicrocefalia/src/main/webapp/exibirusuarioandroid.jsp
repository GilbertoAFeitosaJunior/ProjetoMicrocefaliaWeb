<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="fragment/head.jsp" %>

        <img src="${requestScope.usuarioAndroid.foto}" width="200" height="200" /> 
        <h2>${requestScope.usuarioAndroid.nome}</h2>
        <p><strong> ID:</strong> ${requestScope.usuarioAndroid.id}</p>
        <p><strong>ID GOOGLE: </strong>${requestScope.usuarioAndroid.idgoogle}</p>
        <p><strong>E-MAIL:</strong> ${requestScope.usuarioAndroid.email}</p>
        <p><strong>TELEFONE:</strong> ${requestScope.usuarioAndroid.ddd} - ${requestScope.usuarioAndroid.telefone}</p>
        <p><strong>DATA DE NASCIMENTO: </strong>${requestScope.usuarioAndroid.datanascimento}</p>        
        <p><strong>LOGRADOURO:</strong> ${requestScope.usuarioAndroid.logradouro} </p>
        <p><strong>NÚMERO:</strong> ${requestScope.usuarioAndroid.numero} </p>
        <p><strong>BAIRRO: </strong>${requestScope.usuarioAndroid.bairro} </p>
        <p><strong>CIDADE:</strong> ${requestScope.usuarioAndroid.cidade} </p>
        <p><strong>ESTADO: </strong>${requestScope.usuarioAndroid.estado} </p>
        <p><strong>PAIS:</strong> ${requestScope.usuarioAndroid.pais} </p>
        <p><strong>CEP:</strong> ${requestScope.usuarioAndroid.cep}</p>


<%@include file="fragment/foot.jsp" %>