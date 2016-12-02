<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("usuLogado") == null) {
        response.sendRedirect("login.jsp");
    }
%>