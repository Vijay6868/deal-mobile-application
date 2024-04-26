package com.example.dealsapp;

public class Admin extends User{
    private String jobcode;
    public Admin(String username, String password, String fname, String lname, String email, String jobCode) {
        super(username, password, fname, lname, email);
        this.jobcode = jobCode;
    }
}
