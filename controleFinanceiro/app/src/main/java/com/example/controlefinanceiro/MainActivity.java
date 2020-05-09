package com.example.controlefinanceiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText descricao;
    private EditText valor;

    private FinancasDAO dao;
    private Financas financas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        descricao = findViewById(R.id.editDescricao);
        valor = findViewById(R.id.editValor);
        dao = new FinancasDAO(this);

        //se tiver um aluno na intenção
        Intent it = getIntent();
        if (it.hasExtra("financas")){
            financas = (Financas) it.getSerializableExtra("financas");
            descricao.setText(financas.getDescricao());
            valor.setText(financas.getValor());
        }

    }

    public void salvar(View view){
        if (financas == null){
            Financas financas = new Financas();
            financas.setDescricao(descricao.getText().toString());
            financas.setValor(valor.getText().toString());
            long id = dao.inserir(financas);
            Toast.makeText(this, "Financas Inseridas! "+id, Toast.LENGTH_SHORT).show();
        }else {
            financas.setDescricao(descricao.getText().toString());
            financas.setValor(valor.getText().toString());
            dao.atualizar(financas);
            Toast.makeText(this, "Financas Atualizadas", Toast.LENGTH_SHORT).show();
        }
    }
}
