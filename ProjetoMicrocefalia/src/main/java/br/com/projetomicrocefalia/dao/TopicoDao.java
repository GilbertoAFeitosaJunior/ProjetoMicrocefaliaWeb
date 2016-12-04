/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.CategoriaForum;
import br.com.projetomicrocefalia.model.TopicoForum;
import br.com.projetomicrocefalia.model.TopicoRest;
import br.com.projetomicrocefalia.model.TopicosRest;
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
public class TopicoDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    PreparedStatement psTemp = null;
    ResultSet rsTemp = null;

    public void criarTopico(TopicoRest topicoRest) throws SQLException {
        String sql = "INSERT INTO tbl_topicos(id_categoria, id_usuario, titulo, mensagem, data_abertura, data_fechamento, ativo)\n"
                + "    VALUES (?, ?, ?, ?,?, ?, ?)";
        ps = connection.prepareStatement(sql);

        ps.setInt(1, topicoRest.getIdCategoria());
        ps.setInt(2, topicoRest.getIdUsuario());
        ps.setString(3, topicoRest.getTitulo());
        ps.setString(4, topicoRest.getMensagem());
        ps.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
        ps.setDate(6, null);
        ps.setBoolean(7, false);
        ps.execute();
        fecharConexao();

    }

    public List<TopicosRest> listarTopicos(int idCategoria) throws SQLException {
        String sql = "SELECT  tbl_topicos.id, tbl_topicos.titulo, tbl_topicos.mensagem, tbl_topicos.data_abertura, tbl_topicos.data_fechamento, tbl_topicos.id_moderador, \n"
                + "tbl_topicos.ativo, tbl_usuario.nome, tbl_usuario.foto\n"
                + "FROM tbl_topicos\n"
                + "INNER JOIN tbl_usuario ON tbl_topicos.id_usuario = tbl_usuario.id\n"
                + "WHERE tbl_topicos.id_categoria = ?\n"
                + "ORDER BY tbl_topicos.data_abertura DESC";

        String sql2 = "SELECT tbl_moderador.especialidade, tbl_usuario_painel.nome FROM tbl_moderador\n"
                + "INNER JOIN tbl_usuario_painel ON tbl_moderador.id_usuario_painel = tbl_usuario_painel.id\n"
                + "WHERE tbl_moderador.id = ?";

        ps = connection.prepareStatement(sql);
        ps.setInt(1, idCategoria);
        rs = ps.executeQuery();

        List<TopicosRest> lista = new ArrayList<>();
        TopicosRest topicosRest = null;
        int idModerador;

        while (rs.next()) {

            topicosRest = new TopicosRest();

            topicosRest.setIdTopico(rs.getInt("id"));
            topicosRest.setTitulo(rs.getString("titulo"));
            topicosRest.setMensagem(rs.getString("mensagem"));
            topicosRest.setNomeUsuario(rs.getString("nome"));
            topicosRest.setFotoUsuario(rs.getString("foto"));
            topicosRest.setDataAbertura(rs.getTimestamp("data_abertura"));
            topicosRest.setDataFechamento(rs.getTimestamp("data_fechamento"));
            topicosRest.setAtivo(rs.getBoolean("ativo"));

            idModerador = rs.getInt("id_moderador");
            if (idModerador > 0) {
                psTemp = connection.prepareStatement(sql2);
                psTemp.setInt(1, idModerador);
                rsTemp = psTemp.executeQuery();

                while (rsTemp.next()) {
                    topicosRest.setNomeModerador(rsTemp.getString("nome"));
                    topicosRest.setEspecialidade(rsTemp.getString("especialidade"));

                }
            }
            lista.add(topicosRest);
        }
        return lista;
    }

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
