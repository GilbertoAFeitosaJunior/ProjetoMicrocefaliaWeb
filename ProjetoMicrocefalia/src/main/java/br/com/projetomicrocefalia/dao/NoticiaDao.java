/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.ChamadaNoticia;
import br.com.projetomicrocefalia.model.ComentarTemp;
import br.com.projetomicrocefalia.model.ComentarioRest;
import br.com.projetomicrocefalia.model.CurtidasUsuario;
import br.com.projetomicrocefalia.model.Curtir;
import br.com.projetomicrocefalia.model.CurtirTemp;
import br.com.projetomicrocefalia.model.Noticia;
import br.com.projetomicrocefalia.model.Pesquisa;
import br.com.projetomicrocefalia.model.Usuario;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class NoticiaDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;
    PreparedStatement psTemp = null;
    ResultSet rsTemp = null;

    public void salvarNoticia(Noticia noticia) throws SQLException {
        String sql = "INSERT INTO tbl_noticia(foto, titulo, chamada, data, fonte, noticia, id_usuario_painel)\n"
                + "VALUES (?,?,?,?,?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setString(1, noticia.getFoto());
        ps.setString(2, noticia.getTitulo());
        ps.setString(3, noticia.getChamada());
        ps.setDate(4, new java.sql.Date(noticia.getData().getTime()));
        ps.setString(5, noticia.getFonte());
        ps.setString(6, noticia.getNoticia());
        ps.setInt(7, noticia.getUsuarioPainel().getId());
        ps.execute();
    }

    public void editarNoticia(Noticia noticia) throws SQLException {
        String sql = "UPDATE tbl_noticia  SET foto=?, titulo=?, chamada=?, data=?, fonte=?, noticia=?, id_usuario_painel=?  WHERE id=?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, noticia.getFoto());
        ps.setString(2, noticia.getTitulo());
        ps.setString(3, noticia.getChamada());
        ps.setDate(4, new java.sql.Date(noticia.getData().getTime()));
        ps.setString(5, noticia.getFonte());
        ps.setString(6, noticia.getNoticia());
        ps.setInt(7, noticia.getUsuarioPainel().getId());
        ps.setInt(8, noticia.getId());
        ps.execute();
    }

    public void deletarNoticia(int id) throws SQLException {
        String sql = "DELETE FROM tbl_noticia WHERE id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<Noticia> listaDeNoticia() throws SQLException {
        String sql = "SELECT * FROM tbl_noticia\n"
                + "INNER JOIN tbl_usuario_painel ON tbl_noticia.id_usuario_painel = tbl_usuario_painel.id\n"
                + "ORDER BY tbl_noticia.data DESC";
        List<Noticia> lista = new ArrayList<>();
        Noticia noticia = null;
        UsuarioPainel usuarioPainel = null;

        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            noticia = new Noticia();
            noticia.setId(rs.getInt("id"));
            noticia.setFoto(rs.getString("foto"));
            noticia.setTitulo(rs.getString("titulo"));
            noticia.setChamada(rs.getString("chamada"));
            noticia.setData(rs.getDate("data"));
            noticia.setFonte(rs.getString("fonte"));
            noticia.setNoticia(rs.getString("noticia"));

            usuarioPainel = new UsuarioPainel();
            usuarioPainel.setId(rs.getInt("id_usuario_painel"));
            usuarioPainel.setNome(rs.getString("nome"));
            usuarioPainel.setEmail(rs.getString("email"));
            usuarioPainel.setLogin(rs.getString("login"));
            usuarioPainel.setSenha(rs.getString("senha"));
            usuarioPainel.setDataDoCadastro(rs.getTimestamp("data_cadastro"));
            usuarioPainel.setPermissao(rs.getBoolean("permissao"));
            usuarioPainel.setRoot(rs.getBoolean("root"));
            noticia.setUsuarioPainel(usuarioPainel);

            lista.add(noticia);
        }
        return lista;
    }

    public Noticia exibirNoticia(int id) throws SQLException {
        String sql = "SELECT * FROM tbl_noticia INNER JOIN tbl_usuario_painel ON tbl_noticia.id_usuario_painel = tbl_usuario_painel.id WHERE tbl_noticia.id=?";
        Noticia noticia = null;
        UsuarioPainel usuarioPainel = null;

        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            noticia = new Noticia();

            noticia.setId(rs.getInt("id"));
            noticia.setFoto(rs.getString("foto"));
            noticia.setTitulo(rs.getString("titulo"));
            noticia.setChamada(rs.getString("chamada"));
            noticia.setData(rs.getDate("data"));
            noticia.setFonte(rs.getString("fonte"));
            noticia.setNoticia(rs.getString("noticia"));

            usuarioPainel = new UsuarioPainel();

            usuarioPainel.setId(rs.getInt("id_usuario_painel"));
            usuarioPainel.setNome(rs.getString("nome"));
            usuarioPainel.setEmail(rs.getString("email"));
            usuarioPainel.setLogin(rs.getString("login"));
            usuarioPainel.setSenha(rs.getString("senha"));
            usuarioPainel.setDataDoCadastro(rs.getTimestamp("data_cadastro"));
            usuarioPainel.setPermissao(rs.getBoolean("permissao"));
            usuarioPainel.setRoot(rs.getBoolean("root"));

            noticia.setUsuarioPainel(usuarioPainel);

        }
        return noticia;
    }

    //METEDOS PARA O RESTFULL NOTÍCIA
    public List<ChamadaNoticia> chamadasNoticias(Pesquisa pesquisa) {
        List<ChamadaNoticia> chamadas = new ArrayList<>();
        ChamadaNoticia cn = null;
        String sqlNoticia = "SELECT id, foto, titulo, chamada, count_views  FROM tbl_noticia \n"
                + "WHERE titulo ILIKE  ?\n"
                + "ORDER BY data DESC\n"
                + "LIMIT 10 OFFSET ?*10";
        String sqlCurtir = "SELECT COUNT(*) AS curtir FROM tbl_curtir WHERE id_noticia=? AND curtir=true";
        String sqlComentario = "SELECT COUNT(*) AS comentario FROM tbl_comentario WHERE id_noticia=?";

        try {
            ps = connection.prepareStatement(sqlNoticia);
            ps.setString(1, "%" + pesquisa.getQuery() + "%");
            ps.setInt(2, pesquisa.getPage());
            rs = ps.executeQuery();

            while (rs.next()) {
                cn = new ChamadaNoticia();

                cn.setIdNoticia(rs.getInt("id"));

                psTemp = connection.prepareStatement(sqlCurtir);
                psTemp.setInt(1, cn.getIdNoticia());
                rsTemp = psTemp.executeQuery();
                while (rsTemp.next()) {
                    cn.setQtdCurtida(rsTemp.getInt("curtir"));
                }

                psTemp = connection.prepareStatement(sqlComentario);
                psTemp.setInt(1, cn.getIdNoticia());
                rsTemp = psTemp.executeQuery();
                while (rsTemp.next()) {
                    cn.setQtdComentarios(rsTemp.getInt("comentario"));
                }

                cn.setQtdViews(rs.getInt("count_views"));
                cn.setFoto(rs.getString("foto"));
                cn.setChamada(rs.getString("titulo"));
                cn.setTitulo(rs.getString("titulo"));

                chamadas.add(cn);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ps);
        }

        try {
            psTemp.close();
            rsTemp.close();
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharConexao();
        return chamadas;
    }

    public Noticia exibirNoticiaAndroid(int id) {
        Noticia noticia = null;
        int qtdViews = 0;
        try {
            String sqlCount = "SELECT count_views\n"
                    + "FROM tbl_noticia\n"
                    + "WHERE id=?";
            psTemp = connection.prepareStatement(sqlCount);
            psTemp.setInt(1, id);
            rsTemp = psTemp.executeQuery();

            while (rsTemp.next()) {
                qtdViews = rsTemp.getInt("count_views");
            }

            String sqlUpdate = "UPDATE tbl_noticia\n"
                    + "SET count_views=?\n"
                    + "WHERE id=?";
            psTemp = connection.prepareStatement(sqlUpdate);
            psTemp.setInt(1, qtdViews + 1);
            psTemp.setInt(2, id);
            psTemp.execute();

            noticia = new Noticia();
            String sqlNoticia = "SELECT id, foto, titulo, data, fonte, noticia\n"
                    + "FROM tbl_noticia\n"
                    + "WHERE id=?";

            ps = connection.prepareStatement(sqlNoticia);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                noticia.setId(rs.getInt("id"));
                noticia.setFoto(rs.getString("foto"));
                noticia.setTitulo(rs.getString("titulo"));
                noticia.setData(rs.getDate("data"));
                noticia.setNoticia(rs.getString("noticia"));
                noticia.setFonte(rs.getString("fonte"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharConexao();
        try {
            psTemp.close();
            rsTemp.close();
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return noticia;
    }

    public void curtir(CurtirTemp curtirTemp) {
        String stql = "INSERT INTO tbl_curtir(id_usuario, id_noticia, curtir, data)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(stql);
            ps.setInt(1, curtirTemp.getIdUsuario());
            ps.setInt(2, curtirTemp.getIdNoticia());
            ps.setBoolean(3, true);
            ps.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
            ps.execute();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean discurtir(CurtirTemp curtirTemp) {
        String sqlConsultar = "SELECT * FROM tbl_curtir WHERE id_usuario=? AND id_noticia=?";
        Curtir curtir = null;
        boolean retorno = false;
        try {
            ps = connection.prepareStatement(sqlConsultar);
            ps.setInt(1, curtirTemp.getIdUsuario());
            ps.setInt(2, curtirTemp.getIdNoticia());
            rs = ps.executeQuery();
            while (rs.next()) {
                curtir = new Curtir();
                curtir.setId(rs.getInt("id"));
            }
            if (curtir != null) {
                String sqlDelete = "DELETE FROM tbl_curtir\n"
                        + "WHERE id=?";
                ps = connection.prepareStatement(sqlDelete);
                ps.setInt(1, curtir.getId());
                ps.execute();
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        fecharConexao();
        return retorno;
    }

    public List<CurtidasUsuario> listaCurtir(CurtirTemp curtirTemp) {
        String sql = "SELECT * FROM tbl_curtir\n"
                + "INNER JOIN tbl_usuario ON tbl_curtir.id_usuario = tbl_usuario.id\n"
                + "WHERE tbl_curtir.id_noticia =?\n"
                + "ORDER BY data DESC";
        CurtidasUsuario cu = null;
        List<CurtidasUsuario> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, curtirTemp.getIdNoticia());
            rs = ps.executeQuery();
            while (rs.next()) {
                cu = new CurtidasUsuario();
                cu.setId_usuario(rs.getInt("id_usuario"));
                cu.setFoto(rs.getString("foto"));
                cu.setNome(rs.getString("nome"));
                lista.add(cu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharConexao();
        return lista;
    }

    public void comentar(ComentarTemp comentarTemp) throws SQLException {
        String sql = "INSERT INTO tbl_comentario(id_usuario, id_noticia, comentario, data)\n"
                + "VALUES (?, ?, ?, ?);";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, comentarTemp.getIdUsuario());
        ps.setInt(2, comentarTemp.getIdNoticia());
        ps.setString(3, comentarTemp.getComentario());
        ps.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
        ps.execute();
        fecharConexao();
    }

    public List<ComentarioRest> comentarios(int idNoticia) throws SQLException {
        List<ComentarioRest> lista = new ArrayList<>();
        ComentarioRest cr = null;
        String sql = "SELECT tbl_comentario.id,tbl_usuario.id AS id_usuario, tbl_usuario.nome, tbl_usuario.foto, tbl_comentario.comentario, tbl_comentario.data FROM tbl_comentario\n"
                + "INNER JOIN tbl_usuario ON tbl_comentario.id_usuario = tbl_usuario.id\n"
                + "INNER JOIN tbl_noticia ON tbl_comentario.id_noticia = tbl_noticia.id\n"
                + "WHERE tbl_noticia.id=?\n"
                + "ORDER BY tbl_comentario.data DESC";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, idNoticia);
        rs = ps.executeQuery();
        while (rs.next()) {
            cr = new ComentarioRest();
            cr.setId(rs.getInt("id"));
            cr.setIdUsuario(rs.getInt("id_usuario"));
            cr.setNome(rs.getString("nome"));
            cr.setFoto(rs.getString("foto"));
            cr.setComentario(rs.getString("comentario"));
            cr.setDate(rs.getTimestamp("data"));
            lista.add(cr);
        }
        fecharConexao();
        return lista;
    }

    public void descomentar(int id) throws SQLException {
        String sql = "DELETE FROM tbl_comentario\n"
                + "WHERE  id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        fecharConexao();
    }

    //Método para fecuar as conexões;
    private void fecharConexao() {
        try {
            if (rs != null) {
                if (!rs.isClosed()) {
                    rs.close();
                }
            }
            if (ps != null) {
                if (!ps.isClosed()) {
                    ps.close();
                }
            }
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erro: Ao tentar fechar as conexões.");
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
