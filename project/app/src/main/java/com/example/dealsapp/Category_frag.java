package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class Category_frag extends Fragment implements SelectListener {
    ToggleButton toDo, restaurants;
    F_Featured_Deals deals;
    FrameLayout dealsFrame;
    ArrayList<Deal> dealList;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_category_frag, container, false);
        toDo = view.findViewById(R.id.btThingsToDo);
        deals = new F_Featured_Deals();
        restaurants = view.findViewById(R.id.btRestaurants);
        dealsFrame = view.findViewById(R.id.deals_frame);
        //getChildFragmentManager().beginTransaction()
               // .replace(R.id.deals_frame, deals)
             //   .commit();

       dealList = inputDeals();
        recyclerView = view.findViewById(R.id.c_rv_item);
       RVAdapter adapter = new RVAdapter(dealList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        // Set up toggle button listener for "To do things" category
        toDo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Filter deals for "To do things" category
                    filterByCategory(R.string.c_to_do_things);
                }
            }
        });

        // Set up toggle button listener for "Restaurant" category
        restaurants.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Filter deals for "Restaurant" category
                    filterByCategory(R.string.c_restaurant);
                }
            }
        });


        // Inflate the layout for this fragment
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
    public ArrayList<Deal> inputDeals(){
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
    public void filterByCategory(int categoryResource) {
        ArrayList<Deal> filteredDeals = new ArrayList<>();

        // Get the category string from resources
        String category = getResources().getString(categoryResource);

        for (Deal deal : dealList) {
            if (deal.getCategory()== categoryResource) {
                filteredDeals.add(deal);
            }
        }

        // Update the RecyclerView adapter with the filtered list of deals
        RVAdapter adapter = new RVAdapter(filteredDeals, this);
        recyclerView.setAdapter(adapter);
    }
}
