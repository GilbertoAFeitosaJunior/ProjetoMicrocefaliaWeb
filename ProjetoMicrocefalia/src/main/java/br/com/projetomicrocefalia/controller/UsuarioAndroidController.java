/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.controller;

import br.com.projetomicrocefalia.dao.UsuarioDao;
import br.com.projetomicrocefalia.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioAndroidController", urlPatterns = {"/usuandroidcontroller.do"})
public class UsuarioAndroidController extends HttpServlet {

    private List<Usuario> usuarios = null;
    private UsuarioDao dao = null;
    private Usuario usuario = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String acao = request.getParameter("acao");

        if (acao.equals("listar")) {
            usuarios = new ArrayList<>();
            dao = new UsuarioDao();
            usuarios = dao.listaUsuarios();
            request.setAttribute("usuariosAndroid", usuarios);
            request.getRequestDispatcher("usuariosandroid.jsp").forward(request, response);
        }

        if (acao.equals("exibirperfil")) {
            dao = new UsuarioDao();
            String id = request.getParameter("id");
            if (!id.isEmpty()) {
                usuario = dao.exibirUsuario(Integer.parseInt(id));
                request.setAttribute("usuarioAndroid", usuario);
                request.getRequestDispatcher("exibirusuarioandroid.jsp").forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
