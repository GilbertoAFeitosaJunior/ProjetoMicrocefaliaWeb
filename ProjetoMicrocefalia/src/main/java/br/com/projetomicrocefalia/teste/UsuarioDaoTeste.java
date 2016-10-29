/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.teste;

import br.com.projetomicrocefalia.dao.UsuarioDao;
import br.com.projetomicrocefalia.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class UsuarioDaoTeste {

    private static UsuarioDao dao = null;
    private static Usuario usuario = null;

    private static String nome = "Vanessa castro de oliveira";
    private static String email = "vanessa_feitosa@gmail.com";
    private static String foto = "http://s2.glbimg.com/Zwefj2aDF5P_Knbb1kmRBMkpyHc=/620x0/top/s.glbimg.com/jo/eg/f/original/2016/07/21/13712387_1225861810780142_1689378272_n.jpg";
    private static String idgoogle = "70808080980808908089080809";
    private static String ddd = "81";
    private static String telefone = "98888-5834";
    private static String logradouro = "Rua 75";
    private static String numero = "146";
    private static String bairro = "centro";
    private static String cidade = "São Lourenço da Mata";
    private static String pais = "Brasil";
    private static Date datanascimento = null;
    private static String estado = "PE";

    public static void main(String[] args) {

        salvarUsuario();
        lista();

    }

    public static void salvarUsuario() {
        dao = new UsuarioDao();
        try {
            datanascimento = new SimpleDateFormat("yyyy-MM-dd").parse("1981-05-02");
        } catch (ParseException ex) {
            System.out.println("Erro na data.......");
            Logger.getLogger(UsuarioDaoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuario = new Usuario(nome, email, foto, idgoogle, ddd, telefone, logradouro, numero, bairro, cidade, pais, datanascimento, estado);

        usuario = dao.salvar(usuario);

        System.out.println(usuario.getId().toString());
        System.out.println(usuario.getNome());
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(datanascimento));
    }

    public static void lista() {
        Usuario usu1 = new Usuario(nome, email, foto, idgoogle, ddd, telefone, logradouro, numero, bairro, cidade, pais, datanascimento, estado);
        Usuario usu2 = new Usuario(nome, email, foto, idgoogle, ddd, telefone, logradouro, numero, bairro, cidade, pais, datanascimento, estado);
        Usuario usu3 = new Usuario(nome, email, foto, idgoogle, ddd, telefone, logradouro, numero, bairro, cidade, pais, datanascimento, estado);
        List<Usuario> lista = Arrays.asList(usu1, usu2, usu3);

        System.out.println("For normal'");
        for (Usuario item : lista) {
            System.out.println(item.getNome());
        }

        System.out.println("For no Lambda'");
        lista.forEach(u-> System.out.println(u.getNome()));
     
        
       

    }

}
