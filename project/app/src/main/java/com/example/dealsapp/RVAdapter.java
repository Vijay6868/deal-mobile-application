package com.example.dealsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVHolder> {
    private ArrayList<Deal> originalDeals; // Original list of deals
    private ArrayList<Deal> filteredDeals; // Filtered list of deals
    private SelectListener listener;

    public RVAdapter(ArrayList<Deal> deals, SelectListener listener) {
        this.originalDeals = deals;
        this.filteredDeals = new ArrayList<>(deals); // Initially, filtered list is same as original list
        this.listener = listener;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_carditems, parent, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        Deal deal = filteredDeals.get(position); // Use filtered list
        // Bind data to the ViewHolder
        holder.tvTitle.setText(deal.getTitle());
        String price = Float.toString(deal.getOriginalPrice());
        holder.tvPrice.setText(price);
        holder.ratingBar.setRating(deal.getRating());
        holder.imag.setImageResource((deal.getImgResource()).get(0));

        // Set click listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(deal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredDeals.size(); // Return size of filtered list
    }

    // Method to filter deals based on search query
    public void filter(String query) {
        query = query.toLowerCase().trim(); // Convert query to lowercase and remove leading/trailing whitespace
        filteredDeals.clear(); // Clear the filtered list

        if (query.isEmpty()) {
            filteredDeals.addAll(originalDeals); // If query is empty, show all original deals
        } else {
            for (Deal deal : originalDeals) {
                // Check if the deal title contains the search query
                if (deal.getTitle().toLowerCase().contains(query)) {
                    filteredDeals.add(deal); // Add deal to filtered list if it matches the query
                }
            }
        }
        notifyDataSetChanged(); // Notify adapter of data set change after filtering
    }
}

