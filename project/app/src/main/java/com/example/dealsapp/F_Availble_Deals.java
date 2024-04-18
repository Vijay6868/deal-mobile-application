package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class F_Availble_Deals extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f__availble__deals, container, false);

        // Use getChildFragmentManager() instead of getSupportFragmentManager()
        getChildFragmentManager().beginTransaction()
                .replace(R.id.main_frame_av_de, new F_Featured_Deals())
                .commit();

        // Inflate the layout for this fragment
        return view;
    }
}
