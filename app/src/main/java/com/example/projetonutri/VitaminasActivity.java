package com.example.projetonutri;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class VitaminasActivity extends AppCompatActivity {

    TextView vitaminas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitaminas);

        vitaminas = findViewById(R.id.vitaminasDaRefeicao);
        //Chamada à API e lógica de mostrar as vitaminas que não tem na refeição

//        vitaminas.setText("Algumas vitaminas estão faltando nesta refeição. Sendo elas: \n" + vitaminasArray);
    }
}
