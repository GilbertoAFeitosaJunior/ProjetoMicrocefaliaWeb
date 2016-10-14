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

    public void salvar(UsuarioPainel usuarioPainel) throws Exception {
        try {
            String sql = "INSERT INTO tbl_usuario_painel(nome, email, login, senha, permissao, data_cadastro) "
                    + "VALUES (?,?,?,md5(?),?,?)";

            ps = connection.prepareStatement(sql);
            ps.setString(1, usuarioPainel.getNome());
            ps.setString(2, usuarioPainel.getEmail());
            ps.setString(3, usuarioPainel.getLogin());
            ps.setString(4, usuarioPainel.getSenha());
            ps.setBoolean(5, usuarioPainel.isPermissao());
            ps.setTimestamp(6, new java.sql.Timestamp(usuarioPainel.getDataDoCadastro().getTime()));
            ps.execute();
        } finally {
            System.out.println("sql: " + ps.toString());
            fecharConexao();
        }
    }

    public boolean validarLogin(String login) {
        try {
            String sql = "select * from tbl_usuario_painel where login=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            rs = ps.executeQuery();            
                       
            
            while (rs.next()) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPainelDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioPainelDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
