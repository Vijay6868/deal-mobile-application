package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class C_homeScreen extends AppCompatActivity {
    RecyclerView recyclerView;
    TabLayout tabLayout;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chome_screen);
//        ArrayList<Deal> deals = new ArrayList<>(); // to store Deal class object
//
//        ArrayList<Integer> list1 = new ArrayList<Integer>(); // to store image res id for s listing
//        list1.add(R.drawable.img1);
//        list1.add(R.drawable.img2);
//        list1.add(R.drawable.img3);
//
//        deals.add(new Deal("Pure Milford Sound Cruise",99,list1,5));
//        recyclerView = findViewById(R.id.homeScreen);
//        RVAdapter adapter = new RVAdapter(deals);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);

        tabLayout = findViewById(R.id.home_tab);
        frameLayout = findViewById(R.id.frame_layout);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new F_Featured_Deals())
                .addToBackStack(null)
                .commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment = new F_Featured_Deals();
                        break;

                    case 1:
                        fragment = new Category_frag();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment)
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
    }
}