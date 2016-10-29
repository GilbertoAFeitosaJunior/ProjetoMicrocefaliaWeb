<%-- 
    Document   : confirmacao
    Created on : 04/10/2016, 09:31:36
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aviso</title>
    </head>
    <body>
        <div>
            <h1>Cadastro realizado com sucesso.</h1>
            <button  onClick="enviar()">Clique aqui para para fazer o login</button>
        </div>

    </body>

    <script>
        function enviar() {
            window.location.href = "login.jsp";
        }
    </script>
</html>
