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
            <h1>Operação realizada com sucesso.</h1>
            <button  onClick="enviar()">Clique aqui para pagina FORUM</button>
            <button  onClick="home()">Clique aqui para página HOME</button>
        </div>

    </body>

    <script>
        function enviar() {
            window.location.href = "forum.jsp";
        }
         function home() {
            window.location.href = "welcome.jsp";
        }
    </script>
</html>
