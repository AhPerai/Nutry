package com.example.projetonutri.View.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projetonutri.R;
import com.example.projetonutri.agendaFragment;
import com.example.projetonutri.dicaFragment;
import com.example.projetonutri.perfilFragment;
import com.example.projetonutri.scoreFragment;

public class HomeAdapter extends FragmentStateAdapter {


    public HomeAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new scoreFragment();
            case 2:
                return new dicaFragment();
            case 3:
                return new perfilFragment();
        }
        return new agendaFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
