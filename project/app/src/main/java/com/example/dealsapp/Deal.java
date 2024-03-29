package com.example.dealsapp;

import java.util.ArrayList;
import java.util.List;

public class Deal {
    private String title, description, category, tag;
    private float originalPrice, discountedPrice;
    private boolean discount;
    private ArrayList<Integer> imgResource;
    private int discountRate;
    private float rating;

    public Deal(String title, float originalPrice, ArrayList<Integer> imgResource, int rating) {
        this.title = title;
        this.originalPrice = originalPrice;
        this.imgResource = imgResource;
        this.rating = rating;
    }

    public Deal(String title, String description, String category, String tag, float originalPrice,
                ArrayList <Integer> imgResource) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.tag = tag;
        this.originalPrice = originalPrice;
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getTag() {
        return tag;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public boolean isDiscount() {
        return discount;
    }

    public ArrayList<Integer> getImgResource() {
        return imgResource;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public float getRating() {
        return rating;
    }
}
