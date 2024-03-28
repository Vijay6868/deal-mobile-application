package com.example.dealsapp;

public class Deal {
    private String title, description, category, tag;
    private double originalPrice, discountedPrice;
    private boolean discount;
    private int imgResource;
    private int discountRate;
    public Deal(String title, String description, String category, String tag, double originalPrice, int imgResource) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.tag = tag;
        this.originalPrice = originalPrice;
        this.imgResource = imgResource;
    }


}
