package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class C_homeScreen extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chome_screen);
        ArrayList<Deal> deals = new ArrayList<>(); // to store Deal class object

        ArrayList<Integer> list1 = new ArrayList<Integer>(); // to store image res id for s listing
        list1.add(R.drawable.img1);
        list1.add(R.drawable.img2);
        list1.add(R.drawable.img3);

        deals.add(new Deal("Pure Milford Sound Cruise",99,list1,5));
        recyclerView = findViewById(R.id.homeScreen);
        RVAdapter adapter = new RVAdapter(deals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}