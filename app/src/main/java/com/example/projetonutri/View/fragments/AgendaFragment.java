package com.example.projetonutri.View.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgendaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgendaFragment extends Fragment {

    String titulo;
    TextView tvTtitulo;

    public AgendaFragment() {
        // Required empty public constructor
    }

    public static AgendaFragment newInstance(String param1, String param2) {
        AgendaFragment fragment = new AgendaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);
        Usuario usuario = new Usuario();
        usuario.setNome("Ana");
        titulo = getString(R.string.frase_inicial) + " " +usuario.getNome();
        tvTtitulo = (TextView) view.findViewById(R.id.tv_titulo);
        tvTtitulo.setText(titulo);
        return view;
    }
}