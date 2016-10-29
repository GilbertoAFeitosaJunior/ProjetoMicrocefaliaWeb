<%-- 
    Document   : autenticacao
    Created on : 04/10/2016, 19:42:25
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação do usuário</title>
    </head>
    <body>
        <a href="cadastrousuario.jsp">Criar usuario</a>
        <div style="position: absolute;left: 10%" >
            <h1>Autenticação</h1>

            <form action="autenticador.do?acao=autenticar" method="POST">              
                <input type="text" placeholder="Login"  required size="50" name="login">               
                <input type="password" placeholder="Senha" id="password" required size="50" name="senha">             

                <button type="submit">Fazer login</button>
            </form>
        </div>




    </body>
</html>
