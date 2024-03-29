package com.example.dealsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVHolder> {
    ArrayList<Deal> deals;
    public RVAdapter(ArrayList<Deal> deals){
        this.deals = deals;
    }
    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_carditems,parent,false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        Deal deal = deals.get(position);
        ArrayList<Integer> img_list = deal.getImgResource();
        holder.tvTitle.setText(deal.getTitle());
        String price = Float.toString(deal.getOriginalPrice());
        holder.tvPrice.setText(price);
        holder.ratingBar.setRating(deal.getRating());
        holder.imag.setImageResource((deal.getImgResource()).get(0));
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }
}
