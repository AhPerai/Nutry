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

public class CadastroFragment extends Fragment {

    EditText labelNome;
    EditText labelEmail;
    EditText labelSenha;
    EditText labelIdade;
    EditText labelGenero;
    Button entrar;
    TextView genero;
    TextView idade;
    TextView nome;
    TextView email;
    TextView senha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.cadastro_tab_fragment, container, false);

        labelEmail = root.findViewById(R.id.labelEmail);
        labelSenha = root.findViewById(R.id.labelSenha);
        labelIdade = root.findViewById(R.id.labelIdade);
        labelGenero = root.findViewById(R.id.labelGenero);
        labelNome = root.findViewById(R.id.labelNome);
        nome = root.findViewById(R.id.nome);
        idade = root.findViewById(R.id.idade);
        genero = root.findViewById(R.id.genero);
        senha = root.findViewById(R.id.senha);
        email = root.findViewById(R.id.email);
        entrar = root.findViewById(R.id.buttonEntrar);
//
//
//        nome.setTranslationY(800);
//        idade.setTranslationY(800);
//        genero.setTranslationY(800);
//        email.setTranslationY(800);
//        senha.setTranslationY(800);
//        entrar.setTranslationY(800);
//        labelNome.setTranslationY(800);
//        labelIdade.setTranslationY(800);
//        labelGenero.setTranslationY(800);
//        labelEmail.setTranslationY(800);
//        labelSenha.setTranslationY(800);
//
//        nome.setAlpha(0);
//        idade.setAlpha(0);
//        genero.setAlpha(0);
//        email.setAlpha(0);
//        senha.setAlpha(0);
//        entrar.setAlpha(0);
//        labelNome.setAlpha(0);
//        labelIdade.setAlpha(0);
//        labelGenero.setAlpha(0);
//        labelEmail.setAlpha(0);
//        labelSenha.setAlpha(0);
//
//        senha.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        entrar.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        nome.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        genero.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        idade.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelEmail.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelSenha.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelNome.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelGenero.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//        labelIdade.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();

        return root;
    }
}
