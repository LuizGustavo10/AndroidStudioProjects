package com.example.ifpr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("descricao", aluno.getDescricao());
        values.put("valor", aluno.getValor());
        //values.put("data", new Date() );

        return banco.insert("aluno", null, values);

    }
    public void excluir(Aluno a){
        banco.delete("aluno", "id= ?", new String[]{a.getId().toString()});
    }

    public void atualizar(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("descricao", aluno.getDescricao());
        values.put("valor", aluno.getValor());
        //values.put("data", new Date() );

        banco.update("aluno", values, "id = ?", new String[]{aluno.getId().toString()});
    }

    public List<Aluno> obterTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id","descricao","valor","descricao"},
                null, null, null, null, null);

        while(cursor.moveToNext()){
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setDescricao(cursor.getString(1));
            a.setValor(cursor.getString(2));
            //a.setTelefone(cursor.getString(3));
            alunos.add(a);
        }
        return alunos;
    }
}
