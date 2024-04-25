package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Category_frag extends Fragment {
    Button toDo, restaurants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_category_frag, container, false);
        toDo = view.findViewById(R.id.btThingsToDo);
        toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        restaurants = view.findViewById(R.id.btRestaurants);

        // Inflate the layout for this fragment
        return view;
    }
    public interface CategoryFilterListener {
        void onFilterButtonClicked(String filterType);
    }

}