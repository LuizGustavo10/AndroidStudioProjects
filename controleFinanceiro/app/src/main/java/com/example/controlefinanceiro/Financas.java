package com.example.controlefinanceiro;

import java.io.Serializable;

public class Financas implements Serializable {
    private Integer id;
    private String valor;
    private String Descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    @Override
    public String toString(){
        //return nome;
        return null;
    }
}
