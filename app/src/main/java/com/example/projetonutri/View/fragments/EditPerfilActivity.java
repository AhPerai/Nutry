package com.example.projetonutri.View.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.R;

public class EditPerfilActivity extends AppCompatActivity {

    EditText etNome, etEmail, etSenha, etConfirmaSenha;
    Button btnAtualizar;
    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_perfil);

        etNome = findViewById(R.id.labelEditNome);
        etEmail = findViewById(R.id.labelEditEmail);
        etSenha = findViewById(R.id.labelEditSenha);
        etConfirmaSenha = findViewById(R.id.labelAtualizarSenha);
        btnAtualizar = findViewById(R.id.btnAtualizar);

        ListaUsuario usuarioLogado = new ListaUsuario();

        etNome.setText(usuarioLogado.getUsuarioLogado().getNome());
        etEmail.setText(usuarioLogado.getUsuarioLogado().getEmail());
        etSenha.setText(usuarioLogado.getUsuarioLogado().getSenha());
        etConfirmaSenha.setText(usuarioLogado.getUsuarioLogado().getSenha());

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSenha.getText().toString().equals(etConfirmaSenha.getText().toString())){
                    for(int i = 0; i < usuarioLogado.getUsuarios().size(); i++){
                        if(usuarioLogado.getUsuarios().get(i).getEmail().equals(usuarioLogado.getUsuarioLogado().getEmail())){
                            usuarioLogado.getUsuarios().get(i).setEmail(etEmail.getText().toString());
                            usuarioLogado.getUsuarios().get(i).setNome(etNome.getText().toString());
                            usuarioLogado.getUsuarios().get(i).setSenha(etSenha.getText().toString());
                            usuarioLogado.setUsuarioLogado(usuarioLogado.getUsuarios().get(i));
                            Toast.makeText(EditPerfilActivity.this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                            break;

                        }
                    }
                }else{
                    Toast.makeText(EditPerfilActivity.this, "As senhas digitadas não coincidem!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}