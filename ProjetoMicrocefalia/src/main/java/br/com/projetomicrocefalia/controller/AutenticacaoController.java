package br.com.projetomicrocefalia.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.projetomicrocefalia.dao.UsuarioPainelDao;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gilberto
 */
@WebServlet(urlPatterns = {"/autenticador.do"})
public class AutenticacaoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("usuLogado") != null) {
            session.removeAttribute("usuLogado");
            session.invalidate();

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookies[i].setValue("");
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(-1); // se -1 nao funcionar tente 0 nao lembro bem essa parte
                    response.addCookie(cookies[i]);
                }
            }
        }
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioPainel usuarioPainel;
        UsuarioPainelDao dao;
        String acao = request.getParameter("acao");

        if (acao.equals("autenticar")) {
            try {
                String login = request.getParameter("login");
                String senha = request.getParameter("senha");

                dao = new UsuarioPainelDao();
                usuarioPainel = dao.autenticacao(login, senha);

                if (usuarioPainel != null && usuarioPainel.isPermissao() == true) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuLogado", usuarioPainel);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                } else {
                    if (usuarioPainel != null && usuarioPainel.isPermissao() == false) {
                        request.setAttribute("msg", "Usuário não autenticado, favor aguardar a liberação no sistema");
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    } else {
                        request.setAttribute("msg", "Login e Senha não existe");
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(AutenticacaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
