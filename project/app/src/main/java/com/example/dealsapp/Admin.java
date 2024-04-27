package com.example.dealsapp;

public class Admin extends User{
    private String jobcode;
    public Admin(String userType, String fname,String lname,String username, String password, String email, String jobCode) {
        super(userType,fname, lname,username, password, email);
        this.jobcode = jobCode;
    }
}
