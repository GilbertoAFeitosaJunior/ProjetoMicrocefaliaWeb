/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.controller;

import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao.equals("create")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            boolean permissao = false;

            usuarioPainel = new UsuarioPainel();
            usuarioPainel.setNome(nome);
            usuarioPainel.setEmail(email);
            usuarioPainel.setLogin(login);
            usuarioPainel.setSenha(senha);
            usuarioPainel.setDataDoCadastro(new Date());
            usuarioPainel.setPermissao(permissao);

            response.getWriter().print(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(usuarioPainel.getDataDoCadastro()));
            
            response.sendRedirect("confirmacao.jsp");
        }
    }

}
