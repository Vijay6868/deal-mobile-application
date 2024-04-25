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

        ArrayList<Deal> deals;
        deals = getDeals();
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
        Bundle bundle = new Bundle();
        bundle.putSerializable("deal", myDeal);
        dealDetailsFragment.setArguments(bundle);

        // Replace the current fragment with the deal details fragment
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, dealDetailsFragment)
                .addToBackStack(null)
                .commit();

    }
    public ArrayList<Deal> getDeals(){
        ArrayList<Deal> deals = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>(); // to store image res id for s listing

        list.add(R.drawable.img1);
        list.add(R.drawable.img2);
        list.add(R.drawable.img3);

        ArrayList<Integer> list1 = new ArrayList<>(); // to store image res id for s listing

        list1.add(R.drawable.img11);
        list1.add(R.drawable.img12);
        list1.add(R.drawable.img13);

        ArrayList<Integer> list3 = new ArrayList<>(); // to store image res id for s listing

        list3.add(R.drawable.img31);
        list3.add(R.drawable.img32);
        list3.add(R.drawable.img33);

        ArrayList<Integer> list4 = new ArrayList<>(); // to store image res id for s listing

        list4.add(R.drawable.img41);
        list4.add(R.drawable.img42);
        list4.add(R.drawable.img43);

        ArrayList<Integer> list5 = new ArrayList<>(); // to store image res id for s listing

        list5.add(R.drawable.img51);
        list5.add(R.drawable.img52);
        list5.add(R.drawable.img53);

        deals.add(new Deal("Pure Milford Sound Cruise",99,list,5,R.string.c_to_do_things,R.string.deal_description));
        deals.add(new Deal("Whale Watch and scenic view",99,list1,4,R.string.c_to_do_things,R.string.deal_description));
        deals.add(new Deal("Joe's Garage Five Mile",99,list3,5,R.string.c_restaurant,R.string.deal_description));
        deals.add(new Deal("Winnies Pizza - Dinner",99,list4,4,R.string.c_restaurant,R.string.deal_description));
        deals.add(new Deal("Jet Boat Ride",99,list5,5,R.string.c_to_do_things,R.string.deal_description));

        return deals;
    }
    void performSearch(String query) {
        // Filter the list of deals based on the entered query
        ArrayList<Deal> filteredDeals = new ArrayList<>();
        for (Deal deal : getDeals()) {
            // Check if the deal's title contains the query (you can adjust the search criteria as needed)
            if (deal.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredDeals.add(deal);
            }
        }

        // Update the RecyclerView adapter with the filtered list of deals
        RVAdapter adapter = new RVAdapter(filteredDeals, this);
        recyclerView.setAdapter(adapter);
    }

}