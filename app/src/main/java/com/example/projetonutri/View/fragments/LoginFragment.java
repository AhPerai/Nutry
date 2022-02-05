package com.example.projetonutri.View.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;


public class LoginFragment extends Fragment {

    Button button;
    EditText email, senha;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        button = (Button) view.findViewById(R.id.btnEntrar);
        email = (EditText) view.findViewById(R.id.labelEmail);
        senha = (EditText) view.findViewById(R.id.labelSenha);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StgEmail = email.getText().toString();
                String StgSenha = senha.getText().toString();
                ListaUsuario listaUsuario = new ListaUsuario();
                Usuario usuario = new Usuario();
                int cont = 0;
                for(int i = 0; i < listaUsuario.getUsuarios().size(); i++){
                    if((listaUsuario.getUsuarios().get(i).getEmail().equals(StgEmail)) && (listaUsuario.getUsuarios().get(i).getSenha().equals(StgSenha))){
                        cont = 1;
                        usuario = listaUsuario.getUsuarios().get(i);
                    }
                }
                if(cont == 1){
                    //Toast e Intent
                    Toast.makeText(getContext(), "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    listaUsuario.setUsuarioLogado(usuario);
                    Intent intent = new Intent(getActivity(), HomeActivicy.class);
                    startActivity(intent);
                }else{
                     Toast.makeText(getContext(), "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}