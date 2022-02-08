package com.example.projetonutri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.View.fragments.AguaAdapter;
import com.example.projetonutri.View.fragments.GreenAdapter;

public class RecyclerViewAgua extends AppCompatActivity {

    private AguaAdapter mAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_agua);
        recyclerView = findViewById(R.id.rv_agua);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        mAdapter = new AguaAdapter(ListaUsuario.usuarioLogado.getAguas());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }
}