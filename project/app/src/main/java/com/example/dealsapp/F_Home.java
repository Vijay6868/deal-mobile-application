package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

public class F_Home extends Fragment {

    TabLayout tabLayout;
    FrameLayout frameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f__home, container, false);

        tabLayout = view.findViewById(R.id.home_tab);
        frameLayout = view.findViewById(R.id.frame_layout);

        getChildFragmentManager().beginTransaction().replace(R.id.frame_layout, new F_Featured_Deals())
                .addToBackStack(null)
                .commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // tab screen changes between featured deals and categories
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new F_Featured_Deals();
                        break;

                    case 1:
                        fragment = new Category_frag();
                        break;

                }
                getChildFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
