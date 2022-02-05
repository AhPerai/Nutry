package com.example.projetonutri.View.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.example.projetonutri.Utils.UsuarioLogado;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
        usuarioLogado.setUsuarioLogado(null);
        button = (Button) view.findViewById(R.id.btnEntrar);
        email = (EditText) view.findViewById(R.id.labelEmail);
        senha = (EditText) view.findViewById(R.id.labelSenha);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StgEmail = email.getText().toString();
                String StgSenha = senha.getText().toString();

                //Fazendo a chamada à API
                UsuarioService usuarioService = new RetrofitService().getUsuarioService();
                Call<Usuario> call = usuarioService.verificarLogin( StgEmail, StgSenha);

                call.enqueue(new Callback<Usuario>() {

                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), "Logado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), HomeActivicy.class);
                            startActivity(intent);
                            usuarioLogado.setUsuarioLogado(response.body());
                        }else{
                            Toast.makeText(getContext(), "O usuário ou senha informados são inválidos", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.e("UsuarioService   ", "Erro ao efetuar o cadastro:" + t.getMessage());
                    }
                });



            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}