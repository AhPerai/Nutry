package com.example.projetonutri.View.fragments;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetonutri.Model.Alimento;
import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.R;
import com.example.projetonutri.Service.RefeicaoService;
import com.example.projetonutri.Service.RetrofitService;
import com.example.projetonutri.VitaminasActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RefeicaoAdapter extends RecyclerView.Adapter<RefeicaoAdapter.NumberViewHolder>{

    private static final String TAG = RefeicaoAdapter.class.getSimpleName();


    List<Refeicao> comidas = new ArrayList<>();

    public RefeicaoAdapter(ArrayList<Refeicao> refeicaoArrayList){
        this.comidas = refeicaoArrayList;
    }

    //Carrega a lista de refeição
    @NonNull
    @Override
    public RefeicaoAdapter.NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        int layoutItem = R.layout.list_refeicoes;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutItem, parent, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    //Popular as linhas da tabela de Refeição
    @Override
    public void onBindViewHolder(@NonNull RefeicaoAdapter.NumberViewHolder holder, int position) {
        Log.d(TAG, "#"+position);

        //Recupera a posição da Refeição clicada para recuperar a Refeição
        Refeicao refeicao = comidas.get(position);

        int posicao = refeicao.getId();

        holder.hora.setText(refeicao.getData().toString());

        RefeicaoService refeicaoService = new RetrofitService().getRefeicaoService();
        Call<Refeicao> callRefeicao = refeicaoService.getRefeicaoById(refeicao.getId());

        callRefeicao.enqueue(new Callback<Refeicao>() {
            @Override
            public void onResponse(Call<Refeicao> call, Response<Refeicao> response) {
                Refeicao refeicaoAPI = response.body();
                Log.e("success",response.body().toString());

                Call<List<Alimento>> callAlimentos = refeicaoService.getAlimentosFromRefeicao(refeicaoAPI.getId());
                callAlimentos.enqueue(new Callback<List<Alimento>>() {

                    @Override
                    public void onResponse(Call<List<Alimento>> call, Response<List<Alimento>> response) {
                        refeicaoAPI.setListaAlimento(response.body());
                        holder.refeicao.setText(refeicaoAPI.getListaAlimento().toString());
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
        
        //Ativa o botão de avaliar a Refeição
        holder.verVitaminas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VitaminasActivity.class);

                intent.putExtra("indexDoAlimento", posicao);
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
        public int getItemCount() {
        return comidas.size();
    }

    //Atualiza a lista de refeiçÕes caso novas refeições sejam adicionadas
    public class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView refeicao, hora;
        Button verVitaminas;
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            verVitaminas = itemView.findViewById(R.id.verVitaminas);
            refeicao = itemView.findViewById(R.id.comida);
            hora = itemView.findViewById(R.id.hora);

        }


    }
}
