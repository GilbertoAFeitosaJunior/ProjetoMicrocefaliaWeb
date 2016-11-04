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
        <title>Exibir Usuário</title>
    </head>
    <body>
        <a href="welcome.jsp">Home</a></br></br></br>

        <img src="${requestScope.usuarioAndroid.foto}" width="200" height="200" /> 
        <h2>NOME: ${requestScope.usuarioAndroid.nome}</h2>
        <p>ID: ${requestScope.usuarioAndroid.id}</p>
        <p>ID GOOGLE: ${requestScope.usuarioAndroid.idgoogle}</p>
        <p>E-MAIL: ${requestScope.usuarioAndroid.email}</p>
        <p>TELEFONE: ${requestScope.usuarioAndroid.ddd} - ${requestScope.usuarioAndroid.telefone}</p>
        <p>DATA DE NASCIMENTO: ${requestScope.usuarioAndroid.datanascimento}</p>
        <p>E-MAIL: ${requestScope.usuarioAndroid.email}</p>
        <p>LOGRADOURO: ${requestScope.usuarioAndroid.logradouro} </p>
        <p>NÚMERO: ${requestScope.usuarioAndroid.numero} </p>
        <p>BAIRRO: ${requestScope.usuarioAndroid.bairro} </p>
        <p>CIDADE: ${requestScope.usuarioAndroid.cidade} </p>
        <p>ESTADO: ${requestScope.usuarioAndroid.estado} </p>
        <p>PAIS: ${requestScope.usuarioAndroid.pais} </p>
        



    </body>
</html>
