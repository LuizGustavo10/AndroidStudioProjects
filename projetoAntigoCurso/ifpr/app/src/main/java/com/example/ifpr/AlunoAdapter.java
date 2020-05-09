package com.example.ifpr;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AlunoAdapter extends BaseAdapter {
    private List<Aluno> alunos;
    private Activity activity;

    public AlunoAdapter(Activity activity, List<Aluno> alunos) {
        this.activity = activity;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return alunos.get(i).getId();
    }

    //importante, criando view
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflar item
        View v = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        //peguei os dados dos alunos
        TextView descricao = v.findViewById(R.id.text_descricao);
        TextView valor = v.findViewById(R.id.text_valor);


        Aluno a = alunos.get(i);

        descricao.setText(a.getDescricao());
        valor.setText(a.getValor());

        return v;
    }
}
