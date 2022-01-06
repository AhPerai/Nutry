package com.example.projetonutri.View.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;
import com.example.projetonutri.dao.Conexao;
import com.example.projetonutri.dao.UsuarioDAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class cadastroFragment extends Fragment {

    Button button;
    EditText edit_nome, edit_email, edit_idade, edit_genero, edit_senha;

    public cadastroFragment() {
        // Required empty public constructor
    }

    public static cadastroFragment newInstance(String param1, String param2) {
        cadastroFragment fragment = new cadastroFragment();
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
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        button = (Button) view.findViewById(R.id.btnCadastrar);
        edit_nome = (EditText) view.findViewById(R.id.labelNome);
        edit_email = (EditText) view.findViewById(R.id.labelEmail);
        edit_idade = (EditText) view.findViewById(R.id.labelIdade);
        edit_genero = (EditText) view.findViewById(R.id.labelGenero);
        edit_senha = (EditText) view.findViewById(R.id.labelSenha);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String idade = edit_idade.getText().toString();
                String genero = edit_genero.getText().toString();
                String senha = edit_senha.getText().toString();

                if (nome.isEmpty() || email.isEmpty() && senha.isEmpty() || idade.isEmpty() || genero.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Preencha os campos vazios!", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Usuario usuario = new Usuario(nome, email, senha, idade, genero);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    usuarioDAO.adicionarUsuario(usuario);

                }
            }
        });
        return view;
    }
}