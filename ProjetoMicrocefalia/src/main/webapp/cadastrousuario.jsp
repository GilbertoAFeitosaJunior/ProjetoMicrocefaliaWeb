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
        <title>Cadastro Usuário (Painel de Controle)</title>

        <script src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
        <script type="text/javascript" src="https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/js/metro.min.js"></script>

        <style type="text/css">
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-responsive.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-schemes.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-rtl.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-icons.min.css";
        </style>


        <style>
            .login-form {
                width: 500px;
                height: 630px;
                margin-top: 100px;
                margin: auto;
                background-color: #ffffff;
                opacity: 0;
                -webkit-transform: scale(.8);
                transform: scale(.8);
            }
        </style>

        <script>

            /*
             * Do not use this is a google analytics fro Metro UI CSS
             * */
            if (window.location.hostname !== 'localhost') {

                (function (i, s, o, g, r, a, m) {
                    i['GoogleAnalyticsObject'] = r;
                    i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
                    a = s.createElement(o),
                            m = s.getElementsByTagName(o)[0];
                    a.async = 1;
                    a.src = g;
                    m.parentNode.insertBefore(a, m)
                })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

                ga('create', 'UA-58849249-3', 'auto');
                ga('send', 'pageview');

            }


            $(function () {
                var form = $(".login-form");

                form.css({
                    opacity: 1,
                    "-webkit-transform": "scale(1)",
                    "transform": "scale(1)",
                    "-webkit-transition": ".5s",
                    "transition": ".5s"
                });
            });
        </script>
    </head>
    <body class="bg-darkTeal">
        <div class="login-form padding20 block-shadow">

            <form action="usuariocontroller.do?acao=create" method="POST">
                <h1 class="text-light">Cadastro de Usuário</h1>
                <hr class="thin"/>
                <br />

                <div class="input-control text full-size" data-role="input">
                    <label for="user_login">Nome</label>
                    <input type="text" placeholder="Nome completo"  required size="50" name="nome">
                </div>
                <br />
                <br />

                <div class="input-control text full-size" data-role="input">
                    <label for="user_login">Email</label>
                    <input type="email" placeholder="Email"  required size="50" name="email">
                </div>
                <br />
                <br />

                <div class="input-control text full-size" data-role="input">
                    <label for="user_login">Login</label>
                    <input type="text" placeholder="Login"  required size="50" name="login">
                </div>
                <br />
                <br />

                <div class="input-control password full-size" data-role="input">
                    <label for="user_password">Senha:</label>
                    <input type="password" placeholder="Senha" id="password" required size="50" name="senha">
                    <button class="button helper-button reveal"><span class="mif-looks"></span></button>
                </div>
                <br />
                <br />



                <div class="form-actions">
                    <button type="submit" class="button primary">Criar meu cadastro</button>
                    <a href="login.jsp" class="button link">Fazer o login</a>
                </div>
            </form>
        </div>

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

    </body>
</html>