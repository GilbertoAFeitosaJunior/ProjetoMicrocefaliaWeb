/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.controller;

import br.com.projetomicrocefalia.dao.UsuarioPainelDao;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "usuariocontroller.do", urlPatterns = {"/"})
public class UsuarioController extends HttpServlet {

    private UsuarioPainel usuarioPainel = null;
    private UsuarioPainelDao dao;
    private List<UsuarioPainel> usuarios = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String acao = request.getParameter("acao");
        HttpSession session = request.getSession();

        if (session.getAttribute("usuLogado") != null) {

            if (acao.equals("listaUsuario")) {
                dao = new UsuarioPainelDao();
                try {
                    usuarios = dao.listaUsuarioPainel();
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("liberacaousuario.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            response.sendRedirect("login.jsp");
        }

        if (acao.equals("habilitar")) {
            usuarioPainel = new UsuarioPainel();
            usuarioPainel = (UsuarioPainel) session.getAttribute("usuLogado");
            if (usuarioPainel.isRoot()) {
                try {
                    String id = request.getParameter("id");
                    dao = new UsuarioPainelDao();
                    dao.permissaoParaUsusario(Integer.parseInt(id), true);
                    response.sendRedirect("usuariocontroller.do?acao=listaUsuario");
                } catch (SQLException ex) {
                    request.setAttribute("msg", "Erro Interno do Servidor. (SQL)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("msg", "Erro usuário sem permissão");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }

        if (acao.equals("desabilitar")) {
            usuarioPainel = new UsuarioPainel();
            usuarioPainel = (UsuarioPainel) session.getAttribute("usuLogado");
            if (usuarioPainel.isRoot()) {
                try {
                    String id = request.getParameter("id");
                    dao = new UsuarioPainelDao();
                    dao.permissaoParaUsusario(Integer.parseInt(id), false);
                    response.sendRedirect("usuariocontroller.do?acao=listaUsuario");
                } catch (SQLException ex) {
                    request.setAttribute("msg", "Erro Interno do Servidor. (SQL)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("msg", "Erro usuário sem permissão");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        String acao = request.getParameter("acao");

        if (acao.equals("create")) {
            dao = new UsuarioPainelDao();
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            if (!dao.validarLogin(login)) {
                usuarioPainel = new UsuarioPainel();

                usuarioPainel.setNome(nome);
                usuarioPainel.setEmail(email);
                usuarioPainel.setLogin(login);
                usuarioPainel.setSenha(senha);
                boolean permissao = false;
                usuarioPainel.setPermissao(permissao);
                usuarioPainel.setDataDoCadastro(new Date());

                try {
                    dao.salvar(usuarioPainel);
                } catch (SQLException e) {
                    request.setAttribute("msg", "Erro Interno do Servidor. (SQL)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                } catch (NullPointerException e) {
                    request.setAttribute("msg", "Erro Interno do Servidor, Você esqueceu de preencher algum campo.");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("msg", "Erro_no_servidor");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
                request.getRequestDispatcher("aviso_confirmacao.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Erro usuário já cadastrado, favor aguardar a liberação no sistema");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }
    }
}
