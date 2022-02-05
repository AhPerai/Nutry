package com.example.projetonutri.View.fragments;

import android.graphics.Color;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;
import com.google.android.material.snackbar.Snackbar;

public class CadastroFragment extends Fragment {

    Button button;
    EditText edit_nome, edit_email, edit_idade, edit_genero, edit_senha;

    public CadastroFragment() {
        // Required empty public constructor
    }

    public static CadastroFragment newInstance(String param1, String param2) {
        CadastroFragment fragment = new CadastroFragment();
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
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        button = (Button) view.findViewById(R.id.btnCadastrar);
        edit_nome = (EditText) view.findViewById(R.id.labelNome);
        edit_email = (EditText) view.findViewById(R.id.labelEmail);
        edit_idade= (EditText) view.findViewById(R.id.labelIdade);
        edit_genero= (EditText) view.findViewById(R.id.labelGenero);
        edit_senha= (EditText) view.findViewById(R.id.labelSenha);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String idade = edit_idade.getText().toString();
                String genero = edit_genero.getText().toString();
                String senha = edit_senha.getText().toString();

                ListaUsuario listaUsuario = new ListaUsuario();
                int cont = 0;
                if(!(nome.isEmpty() || email.isEmpty() && senha.isEmpty() || idade.isEmpty() || genero.isEmpty())){
                    for(int i = 0; i < listaUsuario.getUsuarios().size(); i++){
                        if(listaUsuario.getUsuarios().get(i).getEmail().equals(email)){
                            cont = 1;
                        }
                    }
                    if(cont == 0){
                        Usuario usuario = new Usuario(nome, email, senha, idade, genero);
                        listaUsuario.setUsuarios(usuario);
                        Toast.makeText(getContext(), "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getContext(), "Já existe uma conta vinculada a este email", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(), "Preencha os campos vazios", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}