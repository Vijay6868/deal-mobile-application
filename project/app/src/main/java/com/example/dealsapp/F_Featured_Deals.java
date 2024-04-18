package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class F_Featured_Deals extends Fragment implements SelectListener {

    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_f__featured__deals, container, false);

        ArrayList<Deal> deals = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(); // to store image res id for s listing
        list1.add(R.drawable.img1);
        list1.add(R.drawable.img2);
        list1.add(R.drawable.img3);

        deals.add(new Deal("Pure Milford Sound Cruise",99,list1,5));
        recyclerView = view.findViewById(R.id.f_rv_item);
        RVAdapter adapter = new RVAdapter(deals,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClicked(Deal myDeal) {
        F_Deal_details dealDetailsFragment = new F_Deal_details();

        // Pass any necessary data to the deal details fragment using arguments


        // Replace the current fragment with the deal details fragment
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, dealDetailsFragment)
                .addToBackStack(null)
                .commit();

    }
}