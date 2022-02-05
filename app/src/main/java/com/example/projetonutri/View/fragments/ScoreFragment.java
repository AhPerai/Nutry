package com.example.projetonutri.View.fragments;

import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.startForegroundService;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.projetonutri.R;
import com.example.projetonutri.Service.Notificacao;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    Switch lembreteRefeicao, lembreteAgua;
    
    public ScoreFragment() {
        // Required empty public constructor
    }
    
    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
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
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        lembreteRefeicao = view.findViewById(R.id.switch1);
        lembreteAgua = view.findViewById(R.id.switchAgua);
        lembreteRefeicao.setText("Desabilitado");
        lembreteAgua.setText("Desabilitado");
        lembreteAgua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lembreteAgua.isChecked()) {
                    //                   startForegroundService(getContext(), new Intent(getContext(), Notificacao.class));
                    lembreteAgua.setText("Habilitado");
                    Toast.makeText(getContext(), "Você habilitou os lembretes de água", Toast.LENGTH_SHORT).show();
                } else {
                    lembreteAgua.setText("Desabilitado");
                    Toast.makeText(getContext(), "Você desabilitou os lembretes de água", Toast.LENGTH_SHORT).show();

                }
            }
        });
        lembreteRefeicao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (lembreteRefeicao.isChecked()) {
 //                   startForegroundService(getContext(), new Intent(getContext(), Notificacao.class));
                    lembreteRefeicao.setText("Habilitado");
                    Toast.makeText(getContext(), "Você habilitou os lembretes de refeição", Toast.LENGTH_SHORT).show();

                } else {
                    lembreteRefeicao.setText("Desabilitado");
                    Toast.makeText(getContext(), "Você desabilitou os lembretes de refeição", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;
    }
}