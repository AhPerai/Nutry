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
import android.widget.Button;
import android.widget.TextView;
import com.example.projetonutri.DialogAguaFragment;
import com.example.projetonutri.DialogRefeicaoFragment;
import com.example.projetonutri.R;
import com.example.projetonutri.RecyclerViewActivity;
import com.example.projetonutri.RecyclerViewAgua;
import com.example.projetonutri.Utils.UsuarioLogado;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AgendaFragment extends Fragment {
    public AgendaFragment() {
    }

    Button btnAgua, btnRefeicao, btnVerHistoricoRefeicao, btnVerConsumo;
    TextView textoInicio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
//        Texto de boas vindas
        textoInicio.setText("Olá, "+ usuarioLogado.getUsuarioLogado().getNome()+ "!");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_agenda, container, false);

        //Variáveis da tela
        btnAgua = view.findViewById(R.id.button_agua);
        btnRefeicao = view.findViewById(R.id.button_refeicao);
        btnVerHistoricoRefeicao = view.findViewById(R.id.button_verListaRefeicao);
        btnVerConsumo = view.findViewById(R.id.button_verListaAgua);
        textoInicio = view.findViewById(R.id.tv_titulo);

        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
//        Texto de boas vindas
        textoInicio.setText("Olá, "+ usuarioLogado.getUsuarioLogado().getNome()+ "!");


        //Direciona o Usuário para a tela com a lista de consumo de água
        btnVerConsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RecyclerViewAgua.class);
                startActivity(intent);
            }
        });

        //Direciona o Usuário para a tela com a lista de refeições do dia
        btnVerHistoricoRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        //Faz a chamada para o método de abrir a dialog de Criar Refeição
        btnRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialogRefeicao();
            }
        });

        //Faz a chamada para o método de abrir a dialog de Registrar consumo de água
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
        dialogaguaFragment.show(getActivity().getSupportFragmentManager(), "dialog de agua");
    }
    public void showCustomDialogRefeicao(){
        DialogRefeicaoFragment dialogRefeicaoFragment = new DialogRefeicaoFragment();
        dialogRefeicaoFragment.show(getActivity().getSupportFragmentManager(), "dialog de refeicao");
    }
}
