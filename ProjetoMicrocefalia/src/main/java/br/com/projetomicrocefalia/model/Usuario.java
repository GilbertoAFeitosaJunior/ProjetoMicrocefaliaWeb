/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Gilberto
 */
public class Usuario implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private String foto;
    private String idgoogle;
    private String ddd;
    private String telefone;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String pais;
    private Date datanascimento;
    private String estado;
    private String cep;

    public Usuario() {
    }

    public Usuario(String nome, String email, String foto, String idgoogle, String ddd, String telefone, String logradouro, String numero, String bairro, String cidade, String pais, Date datanascimento, String estado) {
        this.nome = nome;
        this.email = email;
        this.foto = foto;
        this.idgoogle = idgoogle;
        this.ddd = ddd;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.pais = pais;
        this.datanascimento = datanascimento;
        this.estado = estado;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdgoogle() {
        return idgoogle;
    }

    public void setIdgoogle(String idgoogle) {
        this.idgoogle = idgoogle;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
    
    
}
