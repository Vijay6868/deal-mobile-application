package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class User_details extends Fragment {

    String _usertype, _fname, _lname, _uname, _email, _bname, _jobcode;
    TextView usertype, fname, lname, uname, email, bname, jobcode;

    public User_details() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false);
    }

}