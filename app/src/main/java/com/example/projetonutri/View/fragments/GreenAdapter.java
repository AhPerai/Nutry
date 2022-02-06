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
import com.example.projetonutri.Model.Vitamina;
import com.example.projetonutri.R;
import com.example.projetonutri.VitaminasActivity;

import java.util.ArrayList;
import java.util.List;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder>{


    private static final String TAG = GreenAdapter.class.getSimpleName();

    List<Refeicao> comidas = new ArrayList<>();
    TextView comidaDoDia;

//    public GreenAdapter(ArrayList<Refeicao> refeicaoArrayList){
//        this.comidas = refeicaoArrayList;
//    }

    @NonNull
    @Override
    public GreenAdapter.NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        int layoutItem = R.layout.list_refeicoes;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutItem, parent, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GreenAdapter.NumberViewHolder holder, int position) {
        Log.d(TAG, "#"+position);

        Refeicao refeicao = comidas.get(position);
        int posicao = position;
        holder.refeicao.setText(refeicao.getRefeicoes().toString());
/*
        holder.hora.setText(refeicao.getDataeHora().toString());
*/
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
        //O tamanho da lista de refeições que tem vinculadas ao usua
        return comidas.size();
    }

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
