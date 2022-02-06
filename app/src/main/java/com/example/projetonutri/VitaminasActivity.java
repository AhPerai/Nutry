package com.example.projetonutri;

import android.os.Bundle;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Vitamina;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.projetonutri.databinding.ActivityVitaminasBinding;

import java.util.ArrayList;

public class VitaminasActivity extends AppCompatActivity {

    TextView vitaminas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitaminas);

        vitaminas = findViewById(R.id.vitaminasDaRefeicao);
        int alimentosDaRefeicao = getIntent().getIntExtra("indexDoAlimento", 1);
        ListaUsuario usuario = new ListaUsuario();
        Refeicao refeicaoSelecionada = usuario.getUsuarioLogado().getRefeicoes().get(alimentosDaRefeicao);
        ArrayList<Vitamina> vitaminasDestaRefeicao = new ArrayList<>();
        for(int i = 0; i <refeicaoSelecionada.getRefeicoes().size(); i++){
            vitaminasDestaRefeicao.addAll(refeicaoSelecionada.getRefeicoes().get(i).getVitamina());
        }

        vitaminas.setText(vitaminasDestaRefeicao.toString());
    }
}