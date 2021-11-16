package com.example.projetonutri.View.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;
import com.example.projetonutri.dao.Conexao;
import com.example.projetonutri.dao.UsuarioDAO;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cadastroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cadastroFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static Conexao conexao = new Conexao();
    Button button;
    EditText nome, email, idade, genero, senha;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public cadastroFragment() {
        // Required empty public constructor
    }

    public static cadastroFragment newInstance(String param1, String param2) {
        cadastroFragment fragment = new cadastroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            nome.findViewById(R.id.labelNome);
            email.findViewById(R.id.labelEmail);
            idade.findViewById(R.id.labelIdade);
            genero.findViewById(R.id.labelGenero);
            senha.findViewById(R.id.labelSenha);
        }
    }

    public void onCadastrar(View view){

        Usuario usuario = new Usuario(nome.getText().toString(), email.getText().toString(),
                senha.getText().toString(),idade.getText().toString(), genero.getText().toString());
        UsuarioDAO.adicionarUsuario(usuario);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }
}