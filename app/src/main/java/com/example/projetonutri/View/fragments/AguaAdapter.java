package com.example.projetonutri.View.fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetonutri.Model.Agua;
import com.example.projetonutri.R;


import java.util.ArrayList;
import java.util.List;

public class AguaAdapter extends RecyclerView.Adapter<AguaAdapter.NumberViewHolder>{

    private static final String TAG = RefeicaoAdapter.class.getSimpleName();

    List<Agua> aguas = new ArrayList<>();

    public AguaAdapter(ArrayList<Agua> aguaArrayList){
        this.aguas = aguaArrayList;
    }

    //Carrega a lista de águas
    @NonNull
    @Override
    public AguaAdapter.NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        int layoutItem = R.layout.list_agua;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutItem, parent, shouldAttachToParentImmediately);
        AguaAdapter.NumberViewHolder viewHolder = new AguaAdapter.NumberViewHolder(view);

        return viewHolder;
    }

    //Popular as linhas da tabela de água
    @Override
    public void onBindViewHolder(@NonNull AguaAdapter.NumberViewHolder holder, int position) {
        Log.d(TAG, "#"+position);
        Agua agua = aguas.get(position);

        holder.tvAgua.setText(String.valueOf(agua.getQuantidadeDeCopos()));
        holder.hora.setText(agua.getDataEHora().toString());
    }

    //Tamanho da lista
    @Override
    public int getItemCount() {
        return aguas.size();
    }

    //Atualiza a lista de consumo de água caso novos consumos sejam adicionados
    public class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView tvAgua, hora;
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAgua = itemView.findViewById(R.id.agua);
            hora = itemView.findViewById(R.id.horaAgua);

        }
    }
}
