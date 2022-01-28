package com.example.projetonutri.View.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
        return inflater.inflate(R.layout.fragment_agenda, container, false);
    }
}