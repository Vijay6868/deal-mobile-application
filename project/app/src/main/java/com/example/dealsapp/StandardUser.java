package com.example.dealsapp;

public class StandardUser extends User{

    public StandardUser(String fname,String lname,String username, String password, String email) {
        super(fname, lname,username, password, email);
    }
}
//user = UserFactory.createUser(userType, _fname, _lname, _uname, _password, _email, _bname, _jobcode);