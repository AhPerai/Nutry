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

import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.R;
import com.example.projetonutri.VitaminasActivity;

import java.util.ArrayList;
import java.util.List;

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

        int posicao = position;
        //TODO atribuir a refeição e  horário as variáveis da tela

//        holder.refeicao.setText(refeicao.getAlimentos().toString());
//        holder.hora.setText(refeicao.getDataeHora().toString());

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
