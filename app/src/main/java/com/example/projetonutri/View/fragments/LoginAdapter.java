package com.example.projetonutri.View.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projetonutri.View.fragments.cadastroFragment;
import com.example.projetonutri.View.fragments.loginFragment;

/*

    Classe para fazer a transição entre login e cadastro

 */
public class LoginAdapter extends FragmentStateAdapter {


    public LoginAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new cadastroFragment();
        }
        return new loginFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
