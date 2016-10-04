/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class Conexao {

    public static Connection getConexao() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/db_microcefalia";
        String usuario = "postgres";
        String senha = "123456";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso...");
        } catch (SQLException ex) {
            System.out.println("Erro: Falha na ao tentar se conectar ao banco");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }

}
