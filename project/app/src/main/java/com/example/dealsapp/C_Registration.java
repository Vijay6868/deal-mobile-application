package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class C_Registration extends AppCompatActivity {
    EditText fname, lname, uname, password, cpassword, email, bname;
    TextView wfname, wlname, wuname, wpassword, wcpassword, wemail, wbname;

    Button btregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cregistration);

        regInput();
        alert();

    }
    private void regInput(){
        fname = findViewById(R.id.tbfirstname_login_r);
        lname = findViewById(R.id.tblastname_login_r);
        uname = findViewById(R.id.tbUsername_login_r);
        password = findViewById(R.id.tbPassword_login_r);
        cpassword = findViewById(R.id.tbConfirmPassword_login_r);
        email = findViewById(R.id.tbEmail_r);
        bname = findViewById(R.id.tbBuisness_name);
    }
    private void alert(){
        wfname = findViewById(R.id.wlb_fname);
        wlname = findViewById(R.id.wlb_lname);
        wuname = findViewById(R.id.wlb_uname);
        wpassword = findViewById(R.id.wlb_password);
        wcpassword = findViewById(R.id.wlb_cpassword);
        wemail = findViewById(R.id.wlb_email);
        wbname = findViewById(R.id.wlb_bname);
    }
}