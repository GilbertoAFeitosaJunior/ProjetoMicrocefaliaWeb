<%-- 
    Document   : validarusuario
    Created on : 14/10/2016, 09:42:45
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validação de Usuario</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
        }
    </style>   
    <body>
        <h1>Lista de Usuários</h1>

        <table style="width:100%"> 
            <tr>
                <th>NOME</th>
                <th>EMAIL</th>
                <th>LOGIN</th>
                <th>SENHA</th>
                <th>PERMISSÃO</th>
                <th>DATA DO CADASTRO</th>
                <th>DATA DA AUTENTICAÇÃO</th>
            </tr>
        </table>
    </body>
</html>
