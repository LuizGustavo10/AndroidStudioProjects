package com.example.conexaoexterna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class NovoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);
    }

    public void salvar (View view) {

    }

    public void cancelar (View view) {
        finish();
    }
}
