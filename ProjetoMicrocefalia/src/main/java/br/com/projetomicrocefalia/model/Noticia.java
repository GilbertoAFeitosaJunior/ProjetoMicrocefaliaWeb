/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gilberto
 */
public class Noticia implements Serializable {

    private int id;
    private String foto;
    private String titulo;
    private String chamada;
    private Date data;
    private String fonte;
    private String noticia;
    private UsuarioPainel usuarioPainel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getChamada() {
        return chamada;
    }

    public void setChamada(String chamada) {
        this.chamada = chamada;
    }

    @XmlTransient
    public String getDataString() {
        if (data != null) {
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        }
        return "";
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public UsuarioPainel getUsuarioPainel() {
        return usuarioPainel;
    }

    public void setUsuarioPainel(UsuarioPainel usuarioPainel) {
        this.usuarioPainel = usuarioPainel;
    }

    

}
