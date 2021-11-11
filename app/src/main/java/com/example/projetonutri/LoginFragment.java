package com.example.projetonutri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.projetonutri.R;

public class LoginFragment extends Fragment {

    EditText email;
    EditText senha;
    Button entrar;
    TextView labelLogin;
    TextView labelSenha;
    TextView cadastro;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup)  inflater.inflate(R.layout.login_tab_fragment, container,  false);

        email = root.findViewById(R.id.labelEmail);
        senha = root.findViewById(R.id.labelSenha);
        entrar = root.findViewById(R.id.buttonEntrar);
        cadastro = root.findViewById(R.id.conta);
        labelLogin = root.findViewById(R.id.login);
        labelSenha = root.findViewById(R.id.senha);

//        email.setTranslationY(800);
//        senha.setTranslationY(800);
//        entrar.setTranslationY(800);
//        cadastro.setTranslationY(800);
//        labelSenha.setTranslationY(800);
//        labelLogin.setTranslationY(800);
//
//        email.setAlpha(0);
//        senha.setAlpha(0);
//        entrar.setAlpha(0);
//        cadastro.setAlpha(0);
//        labelLogin.setAlpha(0);
//        labelSenha.setAlpha(0);
//
//        senha.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        entrar.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        cadastro.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelLogin.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelSenha.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();


        return root;
    }
}
