package com.example.projetonutri;

import android.os.Bundle;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.ListaVitamina;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        ListaVitamina ListaVitaminas = new ListaVitamina();
        int cont = 0;
        for(int j = 0; j < ListaVitaminas.getVitaminas().size(); j++){
            for(int i = 0; i <refeicaoSelecionada.getRefeicoes().size(); i++){
                if(!refeicaoSelecionada.getRefeicoes().get(i).getVitamina().equals(ListaVitaminas.getVitaminas().get(j))){
                    cont +=1;
                }
            }
            if(cont == refeicaoSelecionada.getRefeicoes().size()){
                vitaminasDestaRefeicao.add(ListaVitaminas.getVitaminas().get(j));
            }
            cont = 0;
        }

        Set<Vitamina> vitaminasArray = new HashSet<>();
        vitaminasArray.addAll(vitaminasDestaRefeicao);

        vitaminas.setText("Algumas vitaminas estão faltando nesta refeição. Sendo elas: \n" + vitaminasArray);
    }
}