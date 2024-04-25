package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class F_Home extends Fragment {

    SearchView searchView;
    TabLayout tabLayout;
    FrameLayout frameLayout;
    F_Featured_Deals featuredDealsFragment; // Declare the instance of F_Featured_Deals

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f__home, container, false);

        searchView = view.findViewById(R.id.search_view);
        tabLayout = view.findViewById(R.id.home_tab);
        frameLayout = view.findViewById(R.id.frame_layout);

        // Initialize the instance of F_Featured_Deals
        featuredDealsFragment = new F_Featured_Deals();

        // Set up search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search operation with the entered query
                featuredDealsFragment.performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform search operation as the text changes
                featuredDealsFragment.performSearch(newText);
                return true;
            }
        });

        // Set up tab selection listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Replace the FrameLayout with the corresponding fragment based on the selected tab
                switch (tab.getPosition()) {
                    case 0:
                        replaceFragment(featuredDealsFragment); // Use the instance of F_Featured_Deals
                        break;
                    case 1:
                        replaceFragment(new Category_frag());
                        break;
                    // Add more cases for additional tabs if needed
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Initially, display the first fragment (Featured Deals)
        replaceFragment(featuredDealsFragment); // Use the instance of F_Featured_Deals

        return view;
    }

    // Method to replace the FrameLayout with a new fragment
    private void replaceFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}
