package com.example.projetonutri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.projetonutri.Model.Agua;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.example.projetonutri.Utils.UsuarioLogado;
import com.example.projetonutri.View.fragments.AguaAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewAgua extends AppCompatActivity {

    private AguaAdapter mAdapter;
    RecyclerView recyclerView;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_agua);
        recyclerView = findViewById(R.id.rv_agua);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);

        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
        Usuario usuario = usuarioLogado.getUsuarioLogado();

        UsuarioService usuarioService = new RetrofitService().getUsuarioService();
        Call<List<Agua>> callAgua = usuarioService.getAguaTodayFromUsuario(usuario.getId());

        callAgua.enqueue(new Callback<List<Agua>>() {

            @Override
            public void onResponse(Call<List<Agua>> call, Response<List<Agua>> response) {
                List consumoAguaHoje = response.body();
                ArrayList<Agua> consumoAguaList = new ArrayList<>();
                consumoAguaList.addAll(consumoAguaHoje);

                mAdapter = new AguaAdapter(consumoAguaList);
                recyclerView.setAdapter(mAdapter);
                recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
            }

            @Override
            public void onFailure(Call<List<Agua>> call, Throwable t) {
                Log.e("UsuarioService   ", "Erro buscar o consumo de água:" + t.getMessage());
            }
        });



    }
}