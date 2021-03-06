/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.Moderador;
import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class ModeradorDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void criarModerador(Moderador moderador) throws SQLException {
        String sql = "INSERT INTO tbl_moderador(id_usuario_painel, especialidade, data)\n"
                + "    VALUES (?, ?, ?)";

        ps = connection.prepareStatement(sql);
        ps.setInt(1, moderador.getUsuarioPainel().getId());
        ps.setString(2, moderador.getEspecialidade());
        ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
        ps.execute();
        fecharConexao();
    }

    public boolean autencicarModerador(int idUsuarioPainel) throws SQLException {
        String sql = "SELECT * FROM tbl_moderador WHERE id_usuario_painel=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, idUsuarioPainel);
        rs = ps.executeQuery();
        while (rs.next()) {
            return true;
        }
        return false;

    }

    public Moderador buscarModeradro(UsuarioPainel usuarioPainel) throws SQLException {
        String sql = "SELECT * FROM tbl_moderador WHERE id_usuario_painel=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, usuarioPainel.getId());
        rs = ps.executeQuery();
        Moderador moderador = null;
        while (rs.next()) {
            moderador = new Moderador();
            moderador.setId(rs.getInt("id"));
            moderador.setEspecialidade(rs.getString("especialidade"));
            moderador.setData(rs.getTimestamp("data"));
            moderador.setUsuarioPainel(usuarioPainel);
        }
        return moderador;

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
