/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.Usuario;
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
public class UsuarioDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Método para decidir se vai criar uma novo ou fazer login
    public Usuario salvar(Usuario usuario) {

        usuario = buscarUsuario(usuario);
        if (usuario.getId() == null) {
            usuario = criarUsuario(usuario);
        }
        return usuario;
    }

    //Método para fazer login.
    private Usuario criarUsuario(Usuario usuario) {
        try {
            String sql = "INSERT INTO tbl_usuario (nome, email, foto, idgoogle, telefone, "
                    + "logradouro, numero, bairro, cidade, pais, datanascimento, ddd, estado )"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);";

            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getFoto());
            ps.setString(4, usuario.getIdgoogle());
            ps.setString(5, usuario.getTelefone());
            ps.setString(6, usuario.getLogradouro());
            ps.setString(7, usuario.getNumero());
            ps.setString(8, usuario.getBairro());
            ps.setString(9, usuario.getCidade());
            ps.setString(10, usuario.getPais());
            if (usuario.getDatanascimento() == null) {
                ps.setDate(11, null);
            } else {
                ps.setDate(11, new java.sql.Date(usuario.getDatanascimento().getTime()));
            }

            ps.setString(12, usuario.getDdd());
            ps.setString(13, usuario.getEstado());
            ps.execute();

            sql = "SELECT MAX(id) AS id FROM tbl_usuario";
            ps = connection.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
            }

            return usuario;

        } catch (SQLException ex) {
            System.err.println("Erro: ao tentar salvar no banco de dados");
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            fecharConexao();
        }
    }

    //Método para verificar se existe  no banco.
    private Usuario buscarUsuario(Usuario usu) {
        try {
            String url = "SELECT * FROM tbl_usuario where idgoogle=?";
            ps = connection.prepareStatement(url);
            ps.setString(1, usu.getIdgoogle());
            rs = ps.executeQuery();

            while (rs.next()) {
                usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNome(rs.getString("nome"));
                usu.setEmail(rs.getString("email"));
                usu.setFoto(rs.getString("foto"));
                usu.setIdgoogle(rs.getString("idgoogle"));
                usu.setTelefone(rs.getString("telefone"));
                usu.setLogradouro(rs.getString("logradouro"));
                usu.setNumero(rs.getString("numero"));
                usu.setBairro(rs.getString("bairro"));
                usu.setCidade(rs.getString("cidade"));
                usu.setPais(rs.getString("pais"));
                usu.setDatanascimento(rs.getDate("datanascimento"));
                usu.setDdd(rs.getString("ddd"));
                usu.setEstado(rs.getString("estado"));
            }
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //Método para validar o Usuario
    public boolean validarUsuario(Usuario usuario) {
        try {
            String url = "SELECT * FROM tbl_usuario where id=? and idgoogle=?";
            ps = connection.prepareStatement(url);
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getIdgoogle());
            rs = ps.executeQuery();

            while (rs.next()) {
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    public void editarUsuario(Usuario usuario) {
        try {
            String sql = "UPDATE tbl_usuario\n"
                    + "   SET nome=?, email=?, foto=?, idgoogle=?, telefone=?, logradouro=?, \n"
                    + "       numero=?, bairro=?, cidade=?, pais=?, datanascimento=?, ddd=?, estado=?\n"
                    + " WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getFoto());
            ps.setString(4, usuario.getIdgoogle());
            ps.setString(5, usuario.getTelefone());
            ps.setString(6, usuario.getLogradouro());
            ps.setString(7, usuario.getNumero());
            ps.setString(8, usuario.getBairro());
            ps.setString(9, usuario.getCidade());
            ps.setString(10, usuario.getPais());
            if (usuario.getDatanascimento() == null) {
                ps.setDate(11, null);
            } else {
                ps.setDate(11, new java.sql.Date(usuario.getDatanascimento().getTime()));
            }
            ps.setString(13, usuario.getEstado());
            ps.setInt(14, usuario.getId());
            ps.execute();

            /*
            String sql2 = "SELECT * FROM tbl_usuario where id=?";
            ps = connection.prepareStatement(sql2);
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setIdgoogle(rs.getString("idgoogle"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setLogradouro(rs.getString("logradouro"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setPais(rs.getString("pais"));
                usuario.setDatanascimento(rs.getDate("datanascimento"));
                usuario.setDdd(rs.getString("ddd"));
            }
*/
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }
    
    
    public Usuario exibirUsuario(int id){
        try {
            Usuario usuario = null;
            String url = "SELECT * FROM tbl_usuario where id=?";
            ps = connection.prepareStatement(url);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setIdgoogle(rs.getString("idgoogle"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setLogradouro(rs.getString("logradouro"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setPais(rs.getString("pais"));
                usuario.setDatanascimento(rs.getDate("datanascimento"));
                usuario.setDdd(rs.getString("ddd"));
                usuario.setEstado(rs.getString("estado"));
            }
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
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
