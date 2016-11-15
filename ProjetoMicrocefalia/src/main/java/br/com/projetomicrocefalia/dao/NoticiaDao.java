/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.ChamadaNoticia;
import br.com.projetomicrocefalia.model.Noticia;
import br.com.projetomicrocefalia.model.Pesquisa;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    //METEDOS PARA O RESTFULL
    public List<ChamadaNoticia> chamadasNoticias(Pesquisa pesquisa) {
        List<ChamadaNoticia> chamadas = new ArrayList<>();
        ChamadaNoticia cn = null;
        String sqlNoticia = "SELECT id, foto, titulo, chamada  FROM tbl_noticia \n"
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

                cn.setFoto(rs.getString("foto"));
                cn.setChamada(rs.getString("titulo"));
                cn.setTitulo(rs.getString("titulo"));

                chamadas.add(cn);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ps);
        }

        return chamadas;
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
