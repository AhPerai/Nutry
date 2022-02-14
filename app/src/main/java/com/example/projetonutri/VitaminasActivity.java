package com.example.projetonutri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.Model.Vitamina;
import com.example.projetonutri.Service.RefeicaoService;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VitaminasActivity extends AppCompatActivity {

    TextView vitaminas;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitaminas);

        //Codigo
        vitaminas = findViewById(R.id.vitaminasDaRefeicao);
        button = findViewById(R.id.botaoVitaminas);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.holmesplace.com/pt/pt/blog/wellness/as-vitaminas-essenciais";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        int idRefeicao = getIntent().getIntExtra("indexDoAlimento", 1);

        RefeicaoService refeicaoService = new RetrofitService().getRefeicaoService();
        Call<List<Vitamina>> call = refeicaoService.getVitaminasFaltante(idRefeicao);


        call.enqueue(new Callback<List<Vitamina>>() {

            @Override
            public void onResponse(Call<List<Vitamina>> call, Response<List<Vitamina>> response) {
                List vitaminasresponse = response.body();
                ArrayList<Vitamina> vitaminasList = new ArrayList<>();
                vitaminasList.addAll(vitaminasresponse);
                vitaminas.setText("Algumas vitaminas estão faltando nesta refeição. Sendo elas: \n" + vitaminasList);
            }

            @Override
            public void onFailure(Call<List<Vitamina>> call, Throwable t) {

            }
        });



    }
    }

