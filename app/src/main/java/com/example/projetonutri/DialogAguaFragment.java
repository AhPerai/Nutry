package com.example.projetonutri;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetonutri.Model.Agua;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.Service.AguaService;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.example.projetonutri.Utils.UsuarioLogado;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DialogAguaFragment extends AppCompatDialogFragment {

    Button salvarAgua;
    EditText quantidadeAgua;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog_agua, null);

        builder.setView(view).setTitle("Adição de Consumo de água");

        salvarAgua = view.findViewById(R.id.salvarAgua);
        quantidadeAgua = view.findViewById(R.id.quantidadeAgua);


        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
        Usuario usuario = usuarioLogado.getUsuarioLogado();

        salvarAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantidade = quantidadeAgua.getText().toString();
                int quantidadeAguaInt = Integer.parseInt(quantidade);
                //Fazendo a chamada à API
                AguaService aguaService = new RetrofitService().getAguaService();
                Call<Agua> call = aguaService.createAgua(
                        quantidadeAguaInt,  usuario.getId()
                );


                call.enqueue(new Callback<Agua>() {

                    @Override
                    public void onResponse(Call<Agua> call, Response<Agua> response) {
                        Toast.makeText(getContext(), "Registro de água salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Agua> call, Throwable t) {
                        Log.e("UsuarioService   ", "Erro ao efetuar o cadastro:" + t.getMessage());
                    }
                });
            }
        });

        return builder.create();
    }

}
