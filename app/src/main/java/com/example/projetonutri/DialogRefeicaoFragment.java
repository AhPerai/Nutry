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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.Categoria;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.Model.Refeicao_Alimento;
import com.example.projetonutri.Model.Usuario;
import com.example.projetonutri.Service.CategoriaService;
import com.example.projetonutri.Service.RefeicaoService;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.Service.UsuarioService;
import com.example.projetonutri.Utils.UsuarioLogado;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DialogRefeicaoFragment extends AppCompatDialogFragment {

    Spinner categoriaRefeicao, alimento;
    Button adicionarMaisRefeicao, salvarRefeicao;
    TextView listaAlimentos;

     ArrayList<Categoria> listaCategorias = new ArrayList<>();
     ArrayList<Alimento> listaAlimento = new ArrayList<>();
    ArrayList<Alimento> refeicaoAlimentos = new ArrayList<>();
    Refeicao refeicao = new Refeicao();

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
//        ListaCategoriaAlimento lista = new ListaCategoriaAlimento();

        //TODO aqui você precisa popular o spinner com a lista de categorias
        //Lista de categorias estática
        UsuarioLogado usuarioLogado = UsuarioLogado.getInstance();
        ArrayList<Refeicao> refeicaos = usuarioLogado.getUsuarioLogado().getListaRefeicao();

        CategoriaService categoriaService = new RetrofitService().getCategoriaService();
        Call<List<Categoria>> call = categoriaService.getCategorias();

        call.enqueue(new Callback<List<Categoria>>() {

            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                List<Categoria> categorias = response.body();
                listaCategorias.addAll(categorias);

                ArrayAdapter<Categoria> spinnerArrayAdapter =
                        new ArrayAdapter<Categoria>(getContext(), android.R.layout.simple_spinner_item, listaCategorias);
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                categoriaRefeicao.setAdapter(spinnerArrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("CategoriaService   ", "Erro carregar lista:" + t.getMessage());
            }
        });




        categoriaRefeicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO aqui você precisa popular o spinner com a lista de alimentos

                Categoria selecionado = (Categoria)categoriaRefeicao.getSelectedItem(); //Pega objeto da categoria

                //Pega a categoria selecionada e faz uma chamada para a API buscando os  alimentos
                //vinculado a esta categoria
                Call<List<Alimento>> callAlimento = categoriaService.getAlimentosFromCategoria(selecionado.getId());

                callAlimento.enqueue(new Callback<List<Alimento>>() {

                    @Override
                    public void onResponse(Call<List<Alimento>> call, Response<List<Alimento>> response) {
                        List<Alimento> alimentos = response.body();
                            ArrayAdapter<Alimento> spinnerArrayAdapter =
                                    new ArrayAdapter<Alimento>(getContext(), android.R.layout.simple_spinner_item, alimentos);
                            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            alimento.setAdapter(spinnerArrayAdapter);
                    }
                    @Override
                    public void onFailure(Call<List<Alimento>> call, Throwable t) {
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adicionarMaisRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refeicaoAlimentos.add((Alimento) alimento.getSelectedItem());
                listaAlimentos.setText(refeicaoAlimentos.toString());
                Toast.makeText(getContext(), "Seu alimento foi salvo na lista de alimentos desta refeição", Toast.LENGTH_LONG).show();

            }
        });

        salvarRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pega a refeicao criada, seta o time, adiciona-a para a lista de refeicoes do usuario

                int usuarioId = usuarioLogado.getUsuarioLogado().getId();
                //Chamada à API
                RefeicaoService refeicaoService = new RetrofitService().getRefeicaoService();
                Call<Refeicao> call = refeicaoService.createRefeicao(usuarioId);

                call.enqueue(new Callback<Refeicao>() {

                    @Override
                    public void onResponse(Call<Refeicao> call, Response<Refeicao> response) {
                        refeicao = response.body();
                        Log.e("success",response.body().toString());

                        int refeicaoId = refeicao.getId();

                        //Criando a relação entre refeição e alimento
                        for(int i = 0; i< refeicaoAlimentos.size() ;i++){

                            Call<Refeicao_Alimento> callRelacao = refeicaoService.relacionarRefeicaoAlimento(
                                    refeicaoId, refeicaoAlimentos.get(i).getId_alimento());

                            callRelacao.enqueue(new Callback<Refeicao_Alimento>() {

                                @Override
                                public void onResponse(Call<Refeicao_Alimento> call, Response<Refeicao_Alimento> response) {
                                }

                                @Override
                                public void onFailure(Call<Refeicao_Alimento> call, Throwable t) {
                                    Log.e("RefeicaoService   ", "Erro desenvolver a relação:" + t.getMessage());
                                }
                            });
                        }
                        //Obtendo os Alimentos da Refeicao
                        Call<Refeicao> callRefeicao = refeicaoService.getRefeicaoById(refeicaoId);

                        callRefeicao.enqueue(new Callback<Refeicao>() {
                            @Override
                            public void onResponse(Call<Refeicao> call, Response<Refeicao> response) {
                                refeicao = response.body();
                                Log.e("success",response.body().toString());

                                Call<List<Alimento>> callAlimentos = refeicaoService.getAlimentosFromRefeicao(refeicao.getId());
                                callAlimentos.enqueue(new Callback<List<Alimento>>() {

                                    @Override
                                    public void onResponse(Call<List<Alimento>> call, Response<List<Alimento>> response) {
                                        refeicao.setListaAlimento(response.body());
                                        usuarioLogado.getUsuarioLogado().getListaRefeicao().add(refeicao);
                                        Log.e("success",refeicaoAlimentos.toString());
                                        Log.e("success",response.body().toString());;
                                    }

                                    @Override
                                    public void onFailure(Call<List<Alimento>> call, Throwable t) {
                                        Log.e("RefeicaoService   ", "Erro ao carregar a lista de alimentos:" + t.getMessage());
                                    }
                                });
                            }
                            @Override
                            public void onFailure(Call<Refeicao> call, Throwable t) {
                                Log.e("RefeicaoService   ", "Não foi possível encontrar a Refeição:" + t.getMessage());
                            }
                        });
                    }
                    @Override
                    public void onFailure(Call<Refeicao> call, Throwable t) {
                        Log.e("RefeicaoService   ", "Erro ao gerar refeição:" + t.getMessage());
                    }
                });
                //Fim da chamada

                //Limpa o textView
                listaAlimentos.setText("");
                Toast.makeText(getContext(), "Refeição salva com sucesso!", Toast.LENGTH_LONG).show();
            }
        });


        return builder.create();
    }
}
