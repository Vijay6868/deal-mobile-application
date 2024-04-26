package com.example.dealsapp;

public class Supplier extends User{
    String bname;
    public Supplier(String username, String password, String fname, String lname, String email, String bname) {
        super(username, password, fname, lname, email);
        this.bname = bname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
