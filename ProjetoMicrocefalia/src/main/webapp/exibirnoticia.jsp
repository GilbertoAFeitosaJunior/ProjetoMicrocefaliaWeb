<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibir Notícia</title>
    </head>
    <body>
        <a href="welcome.jsp">Home</a></br></br></br>

        <img src="${requestScope.noticia.foto}" width="400" height="300" /> 
        <h1>${requestScope.noticia.titulo}</h1>
        <h2>${requestScope.noticia.chamada}</h2>
        <p> </strong>${requestScope.noticia.noticia}</p>
        <p>${requestScope.noticia.fonte}</p>
        <p>${requestScope.noticia.data}</p>
      
    </body>
</html>
