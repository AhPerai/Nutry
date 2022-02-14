package com.example.projetonutri.View.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.R;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.example.projetonutri.Utils.UsuarioLogado;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();

        etNome.setText(usuarioLogado.getUsuarioLogado().getNome());
        etEmail.setText(usuarioLogado.getUsuarioLogado().getEmail());

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String senha = etSenha.getText().toString();
                String senhaNova = etConfirmaSenha.getText().toString();

                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || senhaNova.isEmpty()) {
                    Toast.makeText(EditPerfilActivity.this, "Preencha os campos antes de atualizar os dados!", Toast.LENGTH_SHORT).show();
                }else{
                    if(etSenha.getText().toString().equals(etConfirmaSenha.getText().toString())){

                        UsuarioService usuarioService = new RetrofitService().getUsuarioService();
                        Call<Usuario> call = usuarioService.updateUsuario(
                                usuarioLogado.getUsuarioLogado().getId(),
                                email,
                                senha,
                                nome,
                                usuarioLogado.getUsuarioLogado().getIdade(),
                                usuarioLogado.getUsuarioLogado().getGenero()
                        );

                        call.enqueue(new Callback<Usuario>() {

                            @Override
                            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                Toast.makeText(EditPerfilActivity.this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                                usuarioLogado.getUsuarioLogado().setNome(nome);
                                usuarioLogado.getUsuarioLogado().setEmail(email);
                                usuarioLogado.getUsuarioLogado().setSenha(senha);
                            }

                            @Override
                            public void onFailure(Call<Usuario> call, Throwable t) {
                                Log.e("UsuarioService   ", "Erro ao atualizar os dados:" + t.getMessage());
                            }
                        });
                    }
                    else{
                        Toast.makeText(EditPerfilActivity.this, "As senhas digitadas não coincidem!", Toast.LENGTH_SHORT).show();
                    }
                }
           }
        });

    }
}