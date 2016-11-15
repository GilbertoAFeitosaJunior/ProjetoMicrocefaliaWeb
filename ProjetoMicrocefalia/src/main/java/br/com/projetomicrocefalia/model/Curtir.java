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
public class Curtir implements Serializable {
    
    private int id;
    private Usuario usuario;
    private Noticia noticia;
    private boolean curtir;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public boolean isCurtir() {
        return curtir;
    }

    public void setCurtir(boolean curtir) {
        this.curtir = curtir;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
       
    
}
