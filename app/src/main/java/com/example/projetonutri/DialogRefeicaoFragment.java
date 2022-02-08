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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.CategoriaAlimento;
import com.example.projetonutri.Model.ListaCategoriaAlimento;
import com.example.projetonutri.Model.ListaUsuario;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Usuario;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DialogRefeicaoFragment extends AppCompatDialogFragment {

    Spinner categoriaRefeicao, alimento;
    Button adicionarMaisRefeicao, salvarRefeicao;
    TextView listaAlimentos;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_dialog_refeicao, null);

        builder.setView(view).setTitle("Adição de Refeição");


        categoriaRefeicao = view.findViewById(R.id.spinner_categoria);
        alimento = view.findViewById(R.id.spinner_alimento);
        adicionarMaisRefeicao = view.findViewById(R.id.adiconarAlimento);
        salvarRefeicao = view.findViewById(R.id.salvarRefeicao);
        listaAlimentos = view.findViewById(R.id.listaAlimentos);
        ListaCategoriaAlimento lista = new ListaCategoriaAlimento();
        ArrayAdapter<CategoriaAlimento> spinnerArrayAdapter =
                new ArrayAdapter<CategoriaAlimento>(getContext(), android.R.layout.simple_spinner_item, lista.getCategoriaAlimentos());
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoriaRefeicao.setAdapter(spinnerArrayAdapter);


        categoriaRefeicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object selecionado = categoriaRefeicao.getSelectedItem(); //Pega objeto da categoria
                for( int i = 0; i < lista.getCategoriaAlimentos().size(); i++){
                    if (lista.getCategoriaAlimentos().get(i).equals(selecionado)) {
                        ArrayAdapter<Alimento> spinnerArrayAdapter =
                                new ArrayAdapter<Alimento>(getContext(), android.R.layout.simple_spinner_item, lista.getCategoriaAlimentos().get(i).getAlimentos());
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        alimento.setAdapter(spinnerArrayAdapter);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ListaUsuario usuarioLogado = new ListaUsuario();
        adicionarMaisRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioLogado.getUsuarioLogado().setAlimentodaRefeicao((Alimento) alimento.getSelectedItem());
                listaAlimentos.setText(usuarioLogado.getUsuarioLogado().getAlimentodaRefeicao().toString());
                Toast.makeText(getContext(), "Seu alimento foi salvo na lista de alimentos desta refeição", Toast.LENGTH_LONG).show();
            }
        });
        salvarRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentTime = Calendar.getInstance().getTime();
                usuarioLogado.getUsuarioLogado().populaRefeicao(currentTime);
                listaAlimentos.setText(usuarioLogado.getUsuarioLogado().getRefeicoes().toString());
                Toast.makeText(getContext(), "Refeição salva com sucesso!", Toast.LENGTH_LONG).show();
            }
        });


        return builder.create();
    }
}