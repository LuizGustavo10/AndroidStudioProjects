package com.example.conexaoexterna;

public class Usuario extends _Default{
    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Usuario(){
        super();
        //novo caso -1, se não maior igual a zero
        this.id= -1;
        this.email = "";
        this.nome = "";
        this.telefone = "";

    }
    //TODO implementar GEtUsuarios e Salvar e Apagar
}
