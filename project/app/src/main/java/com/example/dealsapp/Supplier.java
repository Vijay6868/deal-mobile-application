package com.example.dealsapp;

public class Supplier extends User{
    String bname;
    public Supplier(String fname,String lname,String username, String password, String email, String bname) {
        super(fname, lname,username, password, email);
        this.bname = bname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
