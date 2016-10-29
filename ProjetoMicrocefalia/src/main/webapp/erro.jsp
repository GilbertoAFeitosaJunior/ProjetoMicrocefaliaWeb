<%-- 
    Document   : confirmacao
    Created on : 04/10/2016, 09:31:36
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>       
        <div>
            <h1> <c:out value="${requestScope.msg}" /></h1>
            A ação não pode ser realizada, <a href="javascript: history.back();">clique aqui</a> para tentar novamente.
        </div>

    </body>
</html>
