package com.example.projetonutri.View.fragments;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.TextView;

import com.example.projetonutri.DialogAguaFragment;
import com.example.projetonutri.DialogRefeicaoFragment;
import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.CategoriaAlimento;
import com.example.projetonutri.Model.ListaCategoriaAlimento;
import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.ListaVitamina;
import com.example.projetonutri.Model.Vitamina;
import com.example.projetonutri.R;
import com.example.projetonutri.RecyclerViewActivity;
import com.example.projetonutri.RecyclerViewAgua;

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

    TextView textoInicio;
    Button btnAgua, btnRefeicao, btnVerHistoricoRefeicao, btnVerConsumo;
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
        btnAgua = view.findViewById(R.id.button_agua);
        btnRefeicao = view.findViewById(R.id.button_refeicao);
        btnVerHistoricoRefeicao = view.findViewById(R.id.button_verListaRefeicao);
        btnVerConsumo = view.findViewById(R.id.button_verListaAgua);
        textoInicio = view.findViewById(R.id.tv_titulo);
        ListaUsuario usuario = new ListaUsuario();
        textoInicio.setText("Olá, "+ usuario.getUsuarioLogado().getNome()+ "!");
        btnVerConsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RecyclerViewAgua.class);
                startActivity(intent);
            }
        });
        btnVerHistoricoRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
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
        DialogAguaFragment dialogaguaFragment = new DialogAguaFragment();
        dialogaguaFragment.show(getActivity().getSupportFragmentManager(),"dialog de agua");
    }

    public void showCustomDialogRefeicao(){
        DialogRefeicaoFragment dialogRefeicaoFragment = new DialogRefeicaoFragment();
        dialogRefeicaoFragment.show(getActivity().getSupportFragmentManager(),"dialog de refeicao");
    }
}
