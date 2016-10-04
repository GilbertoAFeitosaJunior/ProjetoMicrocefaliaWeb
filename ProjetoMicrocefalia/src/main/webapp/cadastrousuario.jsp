<%-- 
    Document   : cadastrousuario
    Created on : 03/10/2016, 19:29:51
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuário (Painel de Controle)</title>
    </head>
    <body>
        <div >
            <h1>Cadastro de Usuário</h1>

            <form action="usuariocontroller.do?acao=create" method="POST">

                <input type="text" placeholder="Nome completo"  required size="50" name="nome">
                <br/><br/>
                <input type="email" placeholder="Email"  required size="50" name="email">
                <br/><br/>
                <input type="text" placeholder="Login"  required size="50" name="login">
                <br/><br/>
                <input type="password" placeholder="Senha" id="password" required size="50" name="senha">
                <br/><br/>
                <input type="password" placeholder="Confirme Senha" id="confirm_password" required size="50">
                <br/><br/>
                <input type="text" placeholder="Codigo de autenticação" required size="50" name="codigo">
                <br/><br/>
                <button type="submit">Enviar</button>
            </form>
        </div>
    </body>
    <script>
        var password = document.getElementById("password")
                , confirm_password = document.getElementById("confirm_password");

        function validatePassword() {
            if (password.value != confirm_password.value) {
                confirm_password.setCustomValidity("Senhas diferentes!");
            } else {
                confirm_password.setCustomValidity('');
            }
        }

        password.onchange = validatePassword;
        confirm_password.onkeyup = validatePassword;
    </script>
</html>
