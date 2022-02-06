package com.example.projetonutri.View.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.example.projetonutri.DialogRefeicaoFragment;
import com.example.projetonutri.R;
import com.example.projetonutri.RecyclerViewActivity;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AgendaFragment extends Fragment {



    public AgendaFragment() {
        // Required empty public constructor
    }

    private static final int NUM_LIST_ITENS = 5;

    Button btnAgua, btnRefeicao, btnVerHistorico;

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
        btnVerHistorico = view.findViewById(R.id.button_verListaRefeicao);
        btnVerHistorico.setOnClickListener(new View.OnClickListener() {
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
