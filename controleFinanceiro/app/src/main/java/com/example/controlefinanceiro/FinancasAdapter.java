package com.example.controlefinanceiro;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FinancasAdapter extends BaseAdapter {
    private List<Financas> financas;
    private Activity activity;

    public FinancasAdapter(Activity activity, List<Financas> financas){
        this.activity = activity;
        this.financas = financas;
    }
    @Override
    public int getCount(){ return financas.size(); }
    @Override
    public Object getItem(int i) { return financas.get(i); }
    @Override
    public long getItemId(int i) { return financas.get(i).getId(); }

    //criando View
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View v = activity.getLayoutInflater().inflate(R.layout.activity_listar_financas, viewGroup, false);
        //pegando dados
        TextView descricao = v.findViewById(R.id.text_descricao);
        TextView valor = v.findViewById(R.id.text_valor);

        Financas a = financas.get(i);

        descricao.setText(a.getDescricao());
        valor.setText(a.getValor());
        return v;
    }

}
