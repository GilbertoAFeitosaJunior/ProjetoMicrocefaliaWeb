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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gilberto
 */
@WebServlet(name = "usuariocontroller.do", urlPatterns = {"/"})
public class UsuarioController extends HttpServlet {

    private UsuarioPainel usuarioPainel = null;
    private UsuarioPainelDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                    response.sendRedirect("confirmacao.jsp");
                } catch (SQLException e) {
                    response.getWriter().append("Erro Interno do Servidor.").append(e.getMessage());
                } catch (NullPointerException e) {
                    response.getWriter().append("Erro Interno do Servidor, Você esqueceu de preencher algum campo.").append(e.getMessage());
                } catch (Exception e) {
                    response.sendRedirect("erro.jsp");
                }
            } else {
                response.getWriter().append("Erro usuario não autenticado, favor aguarda a liberação");
            }
        }

        if (acao.equals("autenticacao")) {
            response.getWriter().print("Autenticado");
        }
    }

}
