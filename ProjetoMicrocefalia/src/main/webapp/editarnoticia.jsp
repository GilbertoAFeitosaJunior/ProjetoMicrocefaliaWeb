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
        <a href="welcome.jsp">Home</a></br>
        <h1>Editar Notícia</h1>
        <form action="noticiacontroller.do?acao=editarnoticia" method="POST">
            <input type="text" value="${requestScope.noticia.id}" readonly="readonly" required size="150" name="idNoticia"/>
            </br>
            </br>
            <input type="text" value="${requestScope.noticia.foto}" required size="150" name="fotoNoticia"/>
            </br>
            </br>
            <input type="text" value="${requestScope.noticia.titulo}" required size="150" name="tituloNoticia"/>
            </br>
            </br>
            <input type="text" value="${requestScope.noticia.chamada}"  required size="150" name="chamadaNoticia"/>
            </br>
            </br>
            <input type="text" value="${requestScope.noticia.fonte}" required size="150" name="fonteNoticia" />
            </br>
            </br>
            <input type="text" value="${requestScope.noticia.data}"  required size="150" name="dataNoticia" id="dataNoticia" />
            </br>
            </br>
            <textarea cols="110"  required rows="20" name="conteudoNoticia" >${requestScope.noticia.noticia}</textarea>

            <br/><br/>
            <button type="submit">SALVAR NOTÍCIA</button>
        </form>

    </body>
</html>
