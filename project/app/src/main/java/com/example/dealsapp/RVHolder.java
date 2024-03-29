package com.example.dealsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {
    TextView tvTitle,tvPrice, tvOffer;
    RatingBar ratingBar;
    ImageView img;

    public RVHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.listingTitle);
        tvPrice = itemView.findViewById(R.id.price);
        ratingBar = itemView.findViewById(R.id.stars);
        tvOffer = itemView.findViewById(R.id.card_offer);

    }
}
