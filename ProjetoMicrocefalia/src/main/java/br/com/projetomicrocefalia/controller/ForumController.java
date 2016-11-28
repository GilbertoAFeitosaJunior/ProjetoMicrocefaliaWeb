/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.controller;

import br.com.projetomicrocefalia.dao.ModeradorDao;
import br.com.projetomicrocefalia.model.Moderador;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gilberto
 */
@WebServlet(name = "ForumController", urlPatterns = {"/forumcontroller.do"})
public class ForumController extends HttpServlet {

    private Moderador moderador;
    private ModeradorDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        UsuarioPainel up = (UsuarioPainel) request.getSession().getAttribute("usuLogado");

        if (up != null && acao.equals("ativar")) {
            String especialidade = request.getParameter("especialidade");
            dao = new ModeradorDao();

            moderador = new Moderador();
            moderador.setIdUsuarioPainel(up.getId());
            moderador.setEspecialidade(especialidade);

            try {
                dao.criarModerador(moderador);
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro não foi possível tornar usuario como moderador. (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("aviso_moderador.jsp").forward(request, response);
        }

    }

}
