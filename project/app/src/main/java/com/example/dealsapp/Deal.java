package com.example.dealsapp;

import java.util.ArrayList;
import java.util.List;

public class Deal {
    private String title, description, category, tag;
    private double originalPrice, discountedPrice;
    private boolean discount;
    private ArrayList<Integer> imgResource;
    private int discountRate;
    private int rating;

    public Deal(String title, double originalPrice, ArrayList<Integer> imgResource, int rating) {
        this.title = title;
        this.originalPrice = originalPrice;
        this.imgResource = imgResource;
        this.rating = rating;
    }

    public Deal(String title, String description, String category, String tag, double originalPrice,
                ArrayList <Integer> imgResource) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.tag = tag;
        this.originalPrice = originalPrice;
        this.imgResource = imgResource;
    }


}
