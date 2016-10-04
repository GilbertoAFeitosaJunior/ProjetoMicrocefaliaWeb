/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.teste;

import br.com.projetomicrocefalia.dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class ConexaoTeste {
    public static void main (String[] args){
        Connection connection =  Conexao.getConexao();       
        try {
            System.out.println(connection.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
