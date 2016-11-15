/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.model;

import java.io.Serializable;

/**
 *
 * @author Gilberto
 */
public class ChamadaNoticia implements Serializable{
    
    private int idNoticia;
    private String foto;
    private String titulo;
    private String chamada;
    private int qtdCurtida;
    private int qtdViews;
    private int qtdComentarios;

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
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

    public int getQtdCurtida() {
        return qtdCurtida;
    }

    public void setQtdCurtida(int qtdCurtida) {
        this.qtdCurtida = qtdCurtida;
    }

    public int getQtdViews() {
        return qtdViews;
    }

    public void setQtdViews(int qtdViews) {
        this.qtdViews = qtdViews;
    }

    public int getQtdComentarios() {
        return qtdComentarios;
    }

    public void setQtdComentarios(int qtdComentarios) {
        this.qtdComentarios = qtdComentarios;
    }
    
    
    
}
