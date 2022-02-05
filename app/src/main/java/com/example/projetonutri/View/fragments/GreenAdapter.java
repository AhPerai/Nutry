package com.example.projetonutri.View.fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetonutri.Model.Refeicao;
import com.example.projetonutri.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder>{


    private static final String TAG = GreenAdapter.class.getSimpleName();

    List<Refeicao> comidas = new ArrayList<>();
    TextView comidaDoDia;

    public GreenAdapter(ArrayList<Refeicao> refeicaoArrayList){
        this.comidas = refeicaoArrayList;
    }

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
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder {

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            //cria as variaveis

        }


    }
}
