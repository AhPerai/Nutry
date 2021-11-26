package com.example.projetonutri;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetonutri.View.fragments.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link agendaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class agendaFragment extends Fragment {

    public agendaFragment() {
        // Required empty public constructor
    }

    public static agendaFragment newInstance() {
        agendaFragment fragment = new agendaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agenda, container, false);
    }
}