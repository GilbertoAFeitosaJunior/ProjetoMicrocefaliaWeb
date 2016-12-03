/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import br.com.projetomicrocefalia.model.Estados;
import br.com.projetomicrocefalia.model.Hospitais;
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
public class HospitaisDao {

    Connection connection = Conexao.getConexao();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Estados> estadosRest() throws SQLException {
        String sql = "SELECT *  FROM tbl_estados_hopitais";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        Estados estados = null;
        List<Estados> lista = new ArrayList<>();
        while (rs.next()) {
            estados = new Estados();
            estados.setId(rs.getInt("id"));
            estados.setEstado(rs.getString("nome"));
            lista.add(estados);
        }
        fecharConexao();
        return lista;
    }

    public List<Hospitais> hospitaisRest(int estado) throws SQLException {
        String sql = "SELECT * FROM public.tbl_hospitais WHERE id_estados_hospitais=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, estado);
        rs = ps.executeQuery();

        Hospitais hospitais = null;
        List<Hospitais> lista = new ArrayList<>();
        while (rs.next()) {
            hospitais = new Hospitais();           
            hospitais.setId(rs.getInt("id"));
            hospitais.setNome(rs.getString("nome"));
            hospitais.setLocalizacao(rs.getString("localizacao"));
            hospitais.setDdd(rs.getInt("ddd"));
            hospitais.setFone(rs.getInt("fone"));
            hospitais.setPublico(rs.getString("publico"));
            hospitais.setAtendimento(rs.getString("atendimento"));
            hospitais.setLongitude(rs.getDouble("longitude"));
            hospitais.setLatitude(rs.getDouble("latitude"));

            lista.add(hospitais);
        }
        fecharConexao();
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
