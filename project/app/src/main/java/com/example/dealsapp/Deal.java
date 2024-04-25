package com.example.dealsapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deal implements Serializable {
    private String title, tag;
    private float originalPrice, discountedPrice;
    private boolean discount;
    private ArrayList<Integer> imgResource;
    private int discountRate,category,description;
    private float rating;

    public Deal(String title, float originalPrice, ArrayList<Integer> imgResource, int rating, int category, int description) {
        this.title = title;
        this.originalPrice = originalPrice;
        this.imgResource = imgResource;
        this.rating = rating;
        this.category = category;
        this.description = description;
    }



    public String getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public int getCategory() {
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
