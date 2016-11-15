<%-- 
    Document   : exibirusuarioandroid
    Created on : 04/11/2016, 10:51:11
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibir Usuário</title>
    </head>
    <body>

        <a href="welcome.jsp">Home</a>

        <h1>Lista de Notícias</h1>

        <table cellpadding="5" border="1px">
            <tr>
                <th>CÓDIGO</th>
                <th>TITULO</th>
                <th>DATA</th>
                <th>USUÁRIO</th>
                <th>OPÇAO DO SISTEMA</th>
            </tr>
            <c:forEach var="noticia" items="${requestScope.noticias}">
                <tr>
                    <td>${noticia.id}</td>
                    <td>${noticia.titulo}</td>
                    <td>${noticia.data}</td>
                    <td>${noticia.usuarioPainel.nome}</td>                       
                    <td>
                        <a href ="noticiacontroller.do?acao=exibirnoticia&id=${noticia.id}"> VISUALIZAR </a>
                        |
                        <a href ="noticiacontroller.do?acao=editarnoticia&id=${noticia.id}"> EDITAR </a>
                        |
                        <a href ="javascript: excluir(${noticia.id})"> EXCLUIR </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script>
            function excluir( id ){
                if(confirm("Deseja Excluir?")) {
                    window.location = "noticiacontroller.do?acao=deletarnoticia&id="+id;
                }
            }
        </script>

    </body>  
  
        
</html>
