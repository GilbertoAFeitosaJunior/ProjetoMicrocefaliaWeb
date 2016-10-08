/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.UsuarioPainel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class UsuarioPainelDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean salvar(UsuarioPainel usuarioPainel) {
        String sql = "INSERT INTO usuario_painel(\n"
                + "            nome, emal, login, senha, permissao, data_cadastro)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?);";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarioPainel.getNome());
            ps.setString(2, usuarioPainel.getEmail());
            ps.setString(3, usuarioPainel.getLogin());
            ps.setString(4, usuarioPainel.getSenha());
            ps.setBoolean(5, usuarioPainel.isPermissao());
            ps.setDate(6, new java.sql.Date(usuarioPainel.getDataDoCadastro().getTime()));

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPainelDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            fecharConexao();
        }
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
