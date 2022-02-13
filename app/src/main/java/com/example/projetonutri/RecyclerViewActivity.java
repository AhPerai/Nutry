package com.example.projetonutri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.example.projetonutri.Utils.UsuarioLogado;
import com.example.projetonutri.View.fragments.RefeicaoAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RefeicaoAdapter mAdapter;
    RecyclerView mNumberList;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mNumberList = findViewById(R.id.rv_agenda);
        //Nesse trecho abaixo será passado o Array de Refeicoes para povoar o RecyclerView
        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
        Usuario usuario = usuarioLogado.getUsuarioLogado();

        UsuarioService usuarioService = new RetrofitService().getUsuarioService();
        Call<List<Refeicao>> callRefeicao = usuarioService.getRefeicaoTodayFromUsuario(usuario.getId());



        callRefeicao.enqueue(new Callback<List<Refeicao>>() {

            @Override
            public void onResponse(Call<List<Refeicao>> call, Response<List<Refeicao>> response) {
                List refeicoesHoje = response.body();
                ArrayList<Refeicao> refeicoesList = new ArrayList<>();
                refeicoesList.addAll(refeicoesHoje);

                RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(context);
                mNumberList.setLayoutManager(LayoutManager);
                mAdapter = new RefeicaoAdapter(refeicoesList);
                mNumberList.setAdapter(mAdapter);
                mNumberList.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
            }

            @Override
            public void onFailure(Call<List<Refeicao>> call, Throwable t) {

            }
        });




    }
}