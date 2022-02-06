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
        /*int alimentosDaRefeicao = getIntent().getIntExtra("indexDoAlimento", 1);
        ListaUsuario usuario = new ListaUsuario();
        Refeicao refeicaoSelecionada = usuario.getUsuarioLogado().getRefeicoes().get(alimentosDaRefeicao);
        ArrayList<Vitamina> vitaminasDestaRefeicao = new ArrayList<>();
        for(int i = 0; i <refeicaoSelecionada.getRefeicoes().size(); i++){
            vitaminasDestaRefeicao.addAll(refeicaoSelecionada.getRefeicoes().get(i).getVitamina());

            vitaminas.setText(vitaminasDestaRefeicao.toString());
        }*/


    }
}