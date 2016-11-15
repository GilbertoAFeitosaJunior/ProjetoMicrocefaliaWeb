package br.com.projetomicrocefalia.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.projetomicrocefalia.dao.NoticiaDao;
import br.com.projetomicrocefalia.model.Noticia;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/noticiacontroller.do"})
public class NoticiaController extends HttpServlet {
    
    private Noticia noticia;
    private NoticiaDao dao;
    private List<Noticia> noticias;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        String acao = request.getParameter("acao");
        
        if (acao.equals("listaNoticia")) {
            try {
                dao = new NoticiaDao();
                noticias = new ArrayList<>();
                noticias = dao.listaDeNoticia();
                
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro Interno do Servidor. (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("noticias", noticias);
            request.getRequestDispatcher("listanoticias.jsp").forward(request, response);
        }
        
        if (acao.equals("exibirnoticia")) {
            String id = request.getParameter("id");
            if (!id.isEmpty()) {
                try {
                    dao = new NoticiaDao();
                    noticia = new Noticia();
                    noticia = dao.exibirNoticia(Integer.parseInt(id));
                    request.setAttribute("noticia", noticia);
                    request.getRequestDispatcher("exibirnoticia.jsp").forward(request, response);
                } catch (SQLException ex) {
                    request.setAttribute("msg", "Erro não foi possível salvar a notícia. (SQL)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                    Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if (acao.equals("editarnoticia")) {
            String id = request.getParameter("id");
            if (!id.isEmpty()) {
                try {
                    dao = new NoticiaDao();
                    noticia = new Noticia();
                    noticia = dao.exibirNoticia(Integer.parseInt(id));
                    request.setAttribute("noticia", noticia);
                    request.getRequestDispatcher("editarnoticia.jsp").forward(request, response);
                } catch (SQLException ex) {
                    request.setAttribute("msg", "Erro não foi possível salvar a notícia. (SQL)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                    Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if (acao.equals("deletarnoticia")) {
            String id = request.getParameter("id");
            if (!id.isEmpty()) {
                try {
                    dao.deletarNoticia(Integer.parseInt(id));
                    
                    response.sendRedirect("noticiacontroller.do?acao=listaNoticia");
                } catch (SQLException ex) {
                    request.setAttribute("msg", "Erro não foi possível excluir a notícia. (SQL)");
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                    Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        String acao = request.getParameter("acao");
        HttpSession session = request.getSession();
        UsuarioPainel usuarioPainel = (UsuarioPainel) session.getAttribute("usuLogado");
        
        if (acao.equals("adicionarNoticia")) {
            try {
                noticia = new Noticia();
                String fotoNoticia = request.getParameter("fotoNoticia");
                String tituloNoticia = request.getParameter("tituloNoticia");
                String chamadaNoticia = request.getParameter("chamadaNoticia");
                String fonteNoticia = request.getParameter("fonteNoticia");
                String dataNoticia = request.getParameter("dataNoticia");
                String conteudoNoticia = request.getParameter("conteudoNoticia");
                
                noticia.setFoto(fotoNoticia);
                noticia.setTitulo(tituloNoticia);
                noticia.setChamada(chamadaNoticia);
                noticia.setFonte(fonteNoticia);
                noticia.setData(new SimpleDateFormat("dd/MM/yyy").parse(dataNoticia));
                noticia.setNoticia(conteudoNoticia);
                noticia.setUsuarioPainel(usuarioPainel);
                
                dao = new NoticiaDao();
                dao.salvarNoticia(noticia);
                request.getRequestDispatcher("aviso_salvo_noticia.jsp").forward(request, response);
            } catch (ParseException ex) {
                request.setAttribute("msg", "Erro de formato. (DATA)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro não foi possível salvar a notícia. (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (acao.equals("editarnoticia")) {
            try {
                noticia = new Noticia();
                String fotoNoticia = request.getParameter("fotoNoticia");
                String tituloNoticia = request.getParameter("tituloNoticia");
                String chamadaNoticia = request.getParameter("chamadaNoticia");
                String fonteNoticia = request.getParameter("fonteNoticia");
                String dataNoticia = request.getParameter("dataNoticia");
                String conteudoNoticia = request.getParameter("conteudoNoticia");
                String idNoticia = request.getParameter("idNoticia");
                
                noticia.setId(Integer.parseInt(idNoticia));
                noticia.setFoto(fotoNoticia);
                noticia.setTitulo(tituloNoticia);
                noticia.setChamada(chamadaNoticia);
                noticia.setFonte(fonteNoticia);
                noticia.setData(new SimpleDateFormat("dd/MM/yyy").parse(dataNoticia));
                noticia.setNoticia(conteudoNoticia);
                noticia.setUsuarioPainel(usuarioPainel);
                
                dao = new NoticiaDao();
                dao.editarNoticia(noticia);
                response.sendRedirect("noticiacontroller.do?acao=listaNoticia");
                
            } catch (ParseException ex) {
                request.setAttribute("msg", "Erro de formato. (DATA)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                request.setAttribute("msg", "Erro não foi possível salvar a notícia. (SQL)");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
