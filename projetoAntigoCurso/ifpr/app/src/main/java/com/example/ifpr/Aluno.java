package com.example.ifpr;

import java.io.Serializable;
import java.util.Date;

public class Aluno implements Serializable {
    private Integer id;
    private String descricao;
    private Date data = new Date();
    private String Valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    @Override
    public String toString(){
        //return nome;
        //return "Nome: "+ nome + "  Cpf: " + cpf + "  Telefone: " + telefone;
        return null;
    }
}
