package com.example.dealsapp;

public class Admin extends User{
    private String jobcode;
    public Admin(String fname,String lname,String username, String password, String email, String jobCode) {
        super(fname, lname,username, password, email);
        this.jobcode = jobCode;
    }
}
