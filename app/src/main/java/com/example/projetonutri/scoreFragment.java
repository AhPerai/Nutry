package com.example.projetonutri;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetonutri.View.fragments.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link scoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class scoreFragment extends Fragment {

    public scoreFragment() {
        // Required empty public constructor
    }

    public static scoreFragment newInstance(String param1, String param2) {
        scoreFragment fragment = new scoreFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }
}