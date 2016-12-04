/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.MensagemOutRest;
import br.com.projetomicrocefalia.model.MensagemRest;
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
public class MensagemDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void salvarMensagem(MensagemRest mensagemRest) throws SQLException {
        String sql = "INSERT INTO tbl_mensagem(id_usuario, id_topico, mensagem, data, revisado)\n"
                + "    VALUES (?, ?, ?, ?, ?)";

        ps = connection.prepareStatement(sql);
        ps.setInt(1, mensagemRest.getIdUsuario());
        ps.setInt(2, mensagemRest.getIdTopico());
        ps.setString(3, mensagemRest.getMensagem());
        ps.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
        ps.setBoolean(5, false);
        ps.execute();
        fecharConexao();

    }

    public List<MensagemOutRest> listarMensagem(int idTopico) throws SQLException {
        String sql = "SELECT tbl_mensagem.mensagem, tbl_mensagem.data, tbl_mensagem.revisado, tbl_usuario.nome, tbl_usuario.foto\n"
                + "FROM tbl_mensagem\n"
                + "INNER JOIN tbl_usuario ON tbl_mensagem.id_usuario = tbl_usuario.id\n"
                + "WHERE id_topico = ?\n"
                + "ORDER BY tbl_mensagem.data ASC";

        ps = connection.prepareStatement(sql);
        ps.setInt(1, idTopico);
        rs = ps.executeQuery();

        MensagemOutRest mensagemOutRest = null;
        List<MensagemOutRest> lista = new ArrayList<>();

        while (rs.next()) {
            mensagemOutRest = new MensagemOutRest();
            
            mensagemOutRest.setNome(rs.getString("nome"));
            mensagemOutRest.setFoto(rs.getString("foto"));
            mensagemOutRest.setMensagem(rs.getString("mensagem"));
            mensagemOutRest.setData(rs.getTimestamp("data"));
            mensagemOutRest.setRevisado(rs.getBoolean("revisado"));

            lista.add(mensagemOutRest);
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
