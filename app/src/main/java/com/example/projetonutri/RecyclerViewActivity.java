package com.example.projetonutri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projetonutri.View.fragments.GreenAdapter;

public class RecyclerViewActivity extends AppCompatActivity {

    private GreenAdapter mAdapter;
    RecyclerView mNumberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mNumberList = findViewById(R.id.rv_agenda);
/*        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this);
        mNumberList.setLayoutManager(LayoutManager);
        mAdapter = new GreenAdapter(ListaUsuario.usuarioLogado.getRefeicoes());
        mNumberList.setAdapter(mAdapter);
        mNumberList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));*/
    }
}