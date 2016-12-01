/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.CategoriaForum;
import br.com.projetomicrocefalia.model.Moderador;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class CategoriaDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void criarCategoria(CategoriaForum cf) throws SQLException {
        String sql = "INSERT INTO tbl_categoria_forum(nome, id_usuario_moderador, data)\n"
                + "    VALUES (?, ?, ?);";

        ps = connection.prepareStatement(sql);
        ps.setString(1, cf.getNome());
        ps.setInt(2, cf.getModerador().getId());
        ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
        ps.execute();
        fecharConexao();
    }

    public void editarCategoria(CategoriaForum cf) throws SQLException {

        String sql = "UPDATE tbl_categoria_forum\n"
                + "SET nome=?, id_usuario_moderador=?, data=?\n"
                + "WHERE id=?;";

        ps = connection.prepareStatement(sql);
        ps.setString(1, cf.getNome());
        ps.setInt(2, cf.getModerador().getId());
        ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
        ps.setInt(4, cf.getId());
        ps.execute();
        fecharConexao();
    }

    public CategoriaForum buscarCategoria(int id) throws SQLException {
        String sql = "SELECT * FROM tbl_categoria_forum  WHERE id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        CategoriaForum cf = null;
        Moderador moderador;
        while (rs.next()) {
            cf = new CategoriaForum();
            moderador = new Moderador();

            cf.setId(rs.getInt("id"));
            cf.setNome(rs.getString("nome"));
            cf.setData(rs.getTimestamp("data"));

            moderador.setId(rs.getInt("id_usuario_moderador"));
            cf.setModerador(moderador);
        }
        fecharConexao();
        return cf;
    }

    public List<CategoriaForum> categoriasList() throws SQLException {
        String sql = "SELECT tbl_categoria_forum.id AS id_forum, tbl_categoria_forum.nome, tbl_categoria_forum.id_usuario_moderador, tbl_categoria_forum.data, tbl_usuario_painel.nome AS nome_usuario FROM tbl_categoria_forum\n"
                + "INNER JOIN tbl_moderador ON tbl_categoria_forum.id_usuario_moderador = tbl_moderador.id\n"
                + "INNER JOIN tbl_usuario_painel ON tbl_moderador.id_usuario_painel = tbl_usuario_painel.id\n"
                + "ORDER BY tbl_categoria_forum.data ASC";
        CategoriaForum cf;
        Moderador moderador;
        UsuarioPainel up;

        List<CategoriaForum> lista = new ArrayList<>();

        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            cf = new CategoriaForum();
            cf.setId(rs.getInt("id_forum"));
            cf.setNome(rs.getString("nome"));
            cf.setData(rs.getTimestamp("data"));

            up = new UsuarioPainel();
            up.setNome(rs.getString("nome_usuario"));

            moderador = new Moderador();
            moderador.setId(rs.getInt("id_usuario_moderador"));
            moderador.setUsuarioPainel(up);

            cf.setModerador(moderador);

            lista.add(cf);
        }
        fecharConexao();
        return lista;
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
