/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.model;

import java.util.Date;

/**
 *
 * @author Gilberto
 */
public class Moderador {

    private int id;
    private UsuarioPainel usuarioPainel;
    private String especialidade;
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioPainel getUsuarioPainel() {
        return usuarioPainel;
    }

    public void setUsuarioPainel(UsuarioPainel usuarioPainel) {
        this.usuarioPainel = usuarioPainel;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
