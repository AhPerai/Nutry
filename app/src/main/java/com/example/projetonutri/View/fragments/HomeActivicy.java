package com.example.projetonutri.View.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.projetonutri.R;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;

public class HomeActivicy extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new HomeAdapter(fm, getLifecycle());
        viewPager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Agenda"));
        tabLayout.addTab(tabLayout.newTab().setText("Lembrete"));
        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));

                // FIM SWITCH DOS FRAGMENTOS DE LOGIN E CADASTRO
            }
        });
    }
}