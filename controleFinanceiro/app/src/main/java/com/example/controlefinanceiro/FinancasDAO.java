package com.example.controlefinanceiro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FinancasDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public FinancasDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Financas financas){
        ContentValues values = new ContentValues();
        values.put("descricao", financas.getDescricao());
        values.put("valor", financas.getValor());

        return banco.insert("financas", null, values);
    }

    public void excluir(Financas a){
        banco.delete("financas", "id = ?", new String[]{a.getId().toString()});
    }

    public void atualizar(Financas financas) {
        ContentValues values = new ContentValues();
        values.put("descricao", financas.getDescricao());
        values.put("valor", financas.getValor());

        banco.update("financas", values, "id = ?", new String[]{financas.getId().toString()});
    }
    public List<Financas> obterTodos() {
        List<Financas> financas = new ArrayList<>();
        Cursor cursor = banco.query("financas", new String[]{"id", "descricao", "valor"},
                null, null, null, null, null);
        while(cursor.moveToNext()){
            Financas a = new Financas();
            a.setId(cursor.getInt(0));
            a.setDescricao(cursor.getString(1));
            a.setValor(cursor.getString(2));
            financas.add(a);
        }
        return financas;


    }
}
