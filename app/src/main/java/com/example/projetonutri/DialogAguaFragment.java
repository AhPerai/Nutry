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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetonutri.Model.Agua;
import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.CategoriaAlimento;
import com.example.projetonutri.Model.ListaCategoriaAlimento;
import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.Usuario;

import java.util.Calendar;
import java.util.Date;

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

        builder.setView(view).setTitle("Adição de Refeição");

        salvarAgua = view.findViewById(R.id.salvarAgua);
        quantidadeAgua = view.findViewById(R.id.quantidadeAgua);

        salvarAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaUsuario usuario = new ListaUsuario();
                Date currentTime = Calendar.getInstance().getTime();
                usuario.getUsuarioLogado().setAgua(new Agua(Integer.parseInt(quantidadeAgua.getText().toString()), currentTime));
                Toast.makeText(getContext(), "Registro de água salvo com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });


        return builder.create();
    }

}