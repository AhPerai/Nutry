package com.example.projetonutri.View.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeAdapter extends FragmentStateAdapter {


    public HomeAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new NotificacaoFragment();
            case 2:
                return new PerfilFragment();
        }
        return new AgendaFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

