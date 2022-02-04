package com.example.projetonutri.View.fragments;

import android.graphics.Color;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

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
                    Snackbar snackbar = Snackbar.make(view, "Por favor, preencha os campos vazios", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    //Criando o usuário
                    int idadeInt = Integer.parseInt(idade);
                    Usuario usuario = new Usuario(nome, email, senha, idadeInt, genero);

                    //Fazendo a chamada à API
                    UsuarioService usuarioService = new RetrofitService().getUsuarioService();
                    Call<Usuario> call = usuarioService.createUsuario(usuario);

                    call.enqueue(new Callback<Usuario>() {

                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            Snackbar snackbar = Snackbar.make(view, "Cadastro salvo com sucesso!", Snackbar.LENGTH_SHORT);
                            snackbar.setBackgroundTint(Color.CYAN);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.show();
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Log.e("UsuarioService   ", "Erro ao efetuar o cadastro:" + t.getMessage());
                        }
                    });
                }
            }
        });
        return view;
    }
}