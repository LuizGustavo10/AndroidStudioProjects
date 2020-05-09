package com.example.ifpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//Activity para o cadastro de aluno
public class MainActivity extends AppCompatActivity {

    private EditText descricao;
    private EditText valor;
    //private EditText telefone;

    private AlunoDAO dao;

    private Aluno aluno = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        descricao = findViewById(R.id.editDecricao);
        valor = findViewById(R.id.editValor);
        //telefone = findViewById(R.id.editTelefone);
        dao = new AlunoDAO( this);

        //se tiver um aluno na intenção
        Intent it = getIntent();
        if (it.hasExtra("aluno")){
            aluno = (Aluno) it.getSerializableExtra("aluno");
            descricao.setText(aluno.getDescricao());
            valor.setText(aluno.getValor());
            //telefone.setText(aluno.getTelefone());

        }
    }

    public void salvar(View view) {
        if(aluno == null){
            Aluno aluno = new Aluno();
            aluno.setDescricao(descricao.getText().toString());
            aluno.setValor(valor.getText().toString());
            //aluno.setTelefone(telefone.getText().toString());
            long id = dao.inserir(aluno);
            Toast.makeText(this, "Aluno Inserido com id" + id, Toast.LENGTH_SHORT).show();
        }else {
            aluno.setDescricao(descricao.getText().toString());
            aluno.setValor(valor.getText().toString());
            //aluno.setTelefone(telefone.getText().toString());
            dao.atualizar(aluno);
            Toast.makeText(this, "Aluno Atualizado!", Toast.LENGTH_SHORT).show();
        }

    }
}
