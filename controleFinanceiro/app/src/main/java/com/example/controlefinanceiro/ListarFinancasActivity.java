package com.example.controlefinanceiro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ListarFinancasActivity extends AppCompatActivity {

    private ListView listView;
    private FinancasDAO dao;
    private List<Financas> financas;
    private List<Financas> financasFiltradas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar_alunos); //mudei para o listar alunos

        //listView = findViewById(R.id.lista_financas);
        listView = findViewById(R.id.lista_alunos);
        dao = new FinancasDAO(this);

        //todas financas
        financas = dao.obterTodos();
        //só financas que foram filtradas
        financasFiltradas.addAll(financas);

        FinancasAdapter adaptador = new FinancasAdapter(this, financasFiltradas);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);

    }

    //inflar menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        //para busca
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procurarFinancas(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater i =getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }

    public void procurarFinancas(String descricao){
        financasFiltradas.clear();
        for (Financas a : financas){
            if (a.getDescricao().toLowerCase().contains(descricao.toLowerCase())){
                financasFiltradas.add(a);
            }
            listView.invalidateViews();
        }
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Financas financasExcluir = financasFiltradas.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja Excluir? ")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        financasFiltradas.remove(financasExcluir);
                        financas.remove(financasExcluir);
                        dao.excluir(financasExcluir);
                        listView.invalidateViews();
                    }
        }).create();
       dialog.show();
    }
    public void cadastrar(MenuItem item){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //pegar posição do aluno
        final Financas financasAtualizar = financasFiltradas.get(menuInfo.position);
        Intent it= new Intent(this, MainActivity.class);
        it.putExtra("financas", financasAtualizar);
        startActivity(it);
    }

    @Override
    public void onResume(){
        super.onResume();
        financasFiltradas.clear();
        financas = dao.obterTodos();
        financasFiltradas.addAll(financas);
        listView.invalidateViews();
    }

}
