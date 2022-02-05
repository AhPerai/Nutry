package com.example.projetonutri.View.fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.projetonutri.DialogRefeicaoFragment;
import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.CategoriaAlimento;
import com.example.projetonutri.Model.ListaCategoriaAlimento;
import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.ListaVitamina;
import com.example.projetonutri.Model.Vitamina;
import com.example.projetonutri.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AgendaFragment extends Fragment {



    public AgendaFragment() {
        // Required empty public constructor
    }

    private static final int NUM_LIST_ITENS = 5;

    private GreenAdapter mAdapter;
    RecyclerView mNumberList;
    Button btnAgua, btnRefeicao;
    List<String> comidas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_agenda, container, false);
        mNumberList = view.findViewById(R.id.rv_agenda);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getContext());
        mNumberList.setLayoutManager(LayoutManager);
        mAdapter = new GreenAdapter(ListaUsuario.usuarioLogado.getRefeicoes());
        mNumberList.setAdapter(mAdapter);
        mNumberList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        btnAgua = view.findViewById(R.id.button_agua);
        btnRefeicao = view.findViewById(R.id.button_refeicao);
        btnRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showCustomDialogRefeicao();

            }
        });
        btnAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
        return view;
    }

    public void showCustomDialog(){
        final Dialog dialog = new Dialog(getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_agua);

        dialog.show();
    }

    public void showCustomDialogRefeicao(){
        DialogRefeicaoFragment dialogRefeicaoFragment = new DialogRefeicaoFragment();
        dialogRefeicaoFragment.show(getActivity().getSupportFragmentManager(),"dialog de refeicao");
    }
}