<%-- 
    Document   : criarnoticiais
    Created on : 04/11/2016, 15:59:57
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Notícias</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
        <script type="text/javascript" src="https://raw.githubusercontent.com/digitalBush/jquery.maskedinput/1.4.1/dist/jquery.maskedinput.min.js"></script>
        <script type="text/javascript">
            $(function ($) {
                $("#dataNoticia").mask("99/99/9999", {placeholder: "mm/dd/yyyy"});
            });
        </script>
    </head>
    <body>
        <h1>Adicionar nova notícia</h1>
        <form action="#" method="POST">

            <input type="text" placeholder="LINK DA FOTO DA NOTÍCIA"  required size="150" name="fotoNoticia"/>
            </br>
            </br>
            <input type="text" placeholder="TITULO DA NOTICIA"  required size="150" name="tituloNoticia"/>
            </br>
            </br>
            <input type="text" placeholder="CHAMADA DA NOTÍCIA"  required size="150" name="chamadaNoticia"/>
            </br>
            </br>
            <input type="text" placeholder="FONTE DA NOTÍCIA"  required size="150" name="fonteNoticia" />
            </br>
            </br>
            <input type="text" placeholder="DATA DA NOTÍCIA"  required size="150" name="dataNoticia" id="dataNoticia" />
            </br>
            </br>
            <textarea cols="110"  placeholder="TEXTO DA NOTÍCIA"  required rows="20" name="conteudoNoticia" ></textarea>

            <br/><br/>
            <button type="submit">SALVAR NOTÍCIA</button>
        </form>
    </body>
</html>
