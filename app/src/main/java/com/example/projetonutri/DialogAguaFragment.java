package com.example.projetonutri;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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

        builder.setView(view).setTitle("Adição de Consumo d'Água");

        salvarAgua = view.findViewById(R.id.salvarAgua);
        quantidadeAgua = view.findViewById(R.id.quantidadeAgua);

        salvarAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criação de um novo consumo d'água
                //Aqui será implementado a chamada à API
                //O consumo de água criado também precisará ser salvo no getlistaAgua de Usuário

//                Date currentTime = Calendar.getInstance().getTime();

                Toast.makeText(getContext(), "Registro de água salvo com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

}