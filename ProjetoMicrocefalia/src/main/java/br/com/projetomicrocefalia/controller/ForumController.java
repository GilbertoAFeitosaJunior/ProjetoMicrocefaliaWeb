/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.controller;

import br.com.projetomicrocefalia.dao.CategoriaDao;
import br.com.projetomicrocefalia.dao.ModeradorDao;
import br.com.projetomicrocefalia.model.CategoriaForum;
import br.com.projetomicrocefalia.model.Moderador;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "ForumController", urlPatterns = {"/forumcontroller.do"})
public class ForumController extends HttpServlet {

    private Moderador moderador;
    private ModeradorDao moderadorDao;
    private CategoriaDao categoriaDao;
    private List<CategoriaForum> listCategoria;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        UsuarioPainel up = (UsuarioPainel) request.getSession().getAttribute("usuLogado");

        if (up != null && acao.equals("listar_categoria")) {
            try {
                categoriaDao = new CategoriaDao();
                listCategoria = categoriaDao.categoriasList();
                request.setAttribute("listaCategoria", listCategoria);
                request.getRequestDispatcher("listacategoria.jsp").forward(request, response);

            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro não foi possível listar as categoria. (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (acao.equals("editarcategoria")) {
            try {
                String id = request.getParameter("id");
                categoriaDao = new CategoriaDao();
                CategoriaForum cf = categoriaDao.buscarCategoria(Integer.parseInt(id));
                if (cf != null) {
                    request.setAttribute("categoria", cf);
                    request.getRequestDispatcher("criarcategoria.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro não foi editar categoria (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        UsuarioPainel up = (UsuarioPainel) request.getSession().getAttribute("usuLogado");

        if (up != null && acao.equals("ativar")) {

            try {
                moderadorDao = new ModeradorDao();
                boolean validacao = moderadorDao.autencicarModerador(up.getId());
                if (!validacao) {
                    String especialidade = request.getParameter("especialidade");

                    moderador = new Moderador();
                    moderador.setUsuarioPainel(up);
                    moderador.setEspecialidade(especialidade);

                    moderadorDao.criarModerador(moderador);
                    request.getRequestDispatcher("aviso_moderador.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "Usuario já é um moderador)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro não foi possível tornar usuario como moderador. (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (acao.equals("novacategoria")) {
            try {
                moderadorDao = new ModeradorDao();
                Moderador moderador = moderadorDao.buscarModeradro(up);
                if (moderador != null) {
                    String nomeDaCategoria = request.getParameter("categoria");

                    CategoriaForum cf = new CategoriaForum();
                    cf.setModerador(moderador);
                    cf.setNome(nomeDaCategoria);

                    categoriaDao = new CategoriaDao();
                    categoriaDao.criarCategoria(cf);
                    request.getRequestDispatcher("aviso_catoria_add.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                request.setAttribute("msg", "Apenas MODERADOR pode realizar essa operação");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (acao.equals("editarcategoria")) {
            try {
                moderadorDao = new ModeradorDao();
                Moderador moderador = moderadorDao.buscarModeradro(up);
                if (moderador != null) {
                    String nomeDaCategoria = request.getParameter("categoria");
                    String id = request.getParameter("id");
                    
                    CategoriaForum cf = new CategoriaForum();
                    cf.setId(Integer.parseInt(id));
                    cf.setModerador(moderador);
                    cf.setNome(nomeDaCategoria);

                    categoriaDao = new CategoriaDao();
                    categoriaDao.editarCategoria(cf);
                    request.getRequestDispatcher("aviso_catoria_add.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                request.setAttribute("msg", "Apenas MODERADOR pode realizar essa operação");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
