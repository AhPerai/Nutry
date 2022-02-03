package com.example.projetonutri.View.fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.projetonutri.R;

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
    private RecyclerView mNumberList;
    Button btnAgua, btnRefeicao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mNumberList = (RecyclerView) getView().findViewById(R.id.rv_agenda);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        mNumberList.setLayoutManager(linearLayoutManager);
//        mNumberList.setHasFixedSize(true);
//        mAdapter = new GreenAdapter(NUM_LIST_ITENS, (GreenAdapter.ListItemClickListener) this);
//        mNumberList.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_agenda, container, false);
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
        final Dialog dialog = new Dialog(getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_refeicao);

        dialog.show();
    }
}