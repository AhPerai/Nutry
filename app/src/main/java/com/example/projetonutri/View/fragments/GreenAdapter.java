package com.example.projetonutri.View.fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetonutri.R;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder>{


    private static final String TAG = GreenAdapter.class.getSimpleName();

    final private ListItemClickListener mOnListItemClickListener;

    private int mNumberItens;

    private static  int viewHolderCount;

    public GreenAdapter(int numeroItens, ListItemClickListener mOnListItemClickListener) {
        this.mOnListItemClickListener = mOnListItemClickListener;
        mNumberItens = numeroItens;
        viewHolderCount = 0;
    }


    interface ListItemClickListener{
        void onListItemClick(int param);
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

        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GreenAdapter.NumberViewHolder holder, int position) {
        Log.d(TAG, "#"+position);
    }

    @Override
    public int getItemCount() {
        return mNumberItens;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
