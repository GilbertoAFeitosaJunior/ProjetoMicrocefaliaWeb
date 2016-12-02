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
                width: 25rem;
                height: 18.75rem;
                position: fixed;
                top: 50%;
                margin-top: -9.375rem;
                left: 50%;
                margin-left: -12.5rem;
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
            <form action="autenticador.do?acao=autenticar" method="POST">              
                <h1 class="text-light">Autenticação</h1>
                <hr class="thin"/>
                <br />
                <div class="input-control text full-size" data-role="input">
                    <label for="user_login">Uuário:</label>
                    <input type="text" placeholder="Login"  required size="50" name="login"> 
                    <button class="button helper-button clear"><span class="mif-cross"></span></button>
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
                    <button type="submit" class="button primary">Fazer login</button>
                    <a href="cadastrousuario.jsp" class="button link">Criar usuario</a>
                </div>
            </form>
        </div>

    </body>
</html>
