package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class C_Registration extends AppCompatActivity {
    EditText fname, lname, uname, password, cpassword, email, bname,jobcode;
    TextView wfname, wlname, wuname, wpassword, wcpassword, wemail, wbname, wjobcode;
    String _fname, _lname, _uname, _password, _cpassword, _email, _bname, _jobcode;
    String userType;
    User user;

    Button btregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cregistration);



        // Initialize EditText and TextView fields
        regInput();
        alert();

        // Set up register button click listener
        handleRegisterButton();

        // Retrieve user type from intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("userType")) {
            userType = intent.getStringExtra("userType");

            //System.out.println(userType);

            // Make business name field visible for supplier
            if (userType.equals("supplier")) {
                bname.setVisibility(View.VISIBLE);
            }
            // Make job code field visible for admin
            if (userType.equals("admin")) {
                jobcode.setVisibility(View.VISIBLE);
            }

            // Create a User instance based on the userType using the factory method
            user = UserFactory.createUser(userType, _fname, _lname, _uname, _password, _email, _bname, _jobcode);
        } else {
            // Handle the case where userType extra is not provided
            // You may want to show an error message or return to the previous activity.
        }


    }
    public void handleRegisterButton(){
        btregister = findViewById(R.id.btRegister);
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve text from EditText fields when the register button is clicked
                regInput();
                alert();

                boolean check = validateInputs();
                if(check){
                    Intent intent = new Intent(C_Registration.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void regInput(){

        fname = findViewById(R.id.tbfirstname_login_r);
        _fname = fname.getText().toString();

        lname = findViewById(R.id.tblastname_login_r);
        _lname = lname.getText().toString();

        uname = findViewById(R.id.tbUsername_login_r);
        _uname = fname.getText().toString();

        password = findViewById(R.id.tbPassword_login_r);
        _password = password.getText().toString();

        cpassword = findViewById(R.id.tbConfirmPassword_login_r);
        _cpassword = cpassword.getText().toString();

        email = findViewById(R.id.tbEmail_r);
        _email = email.getText().toString();

        bname = findViewById(R.id.tbBuisness_name);
        _bname = bname.getText().toString();

        jobcode = findViewById(R.id.tbJobcode);
        _jobcode = jobcode.getText().toString();
    }
    public void alert(){
        wfname = findViewById(R.id.wlb_fname);
        wlname = findViewById(R.id.wlb_lname);
        wuname = findViewById(R.id.wlb_uname);
        wpassword = findViewById(R.id.wlb_password);
        wcpassword = findViewById(R.id.wlb_cpassword);
        wemail = findViewById(R.id.wlb_email);
        wbname = findViewById(R.id.wlb_bname);
        wjobcode = findViewById(R.id.wlb_jobcode);
    }
    public boolean validateInputs() {
        // Create an instance of the Validator class
        Validator validator = new Validator();

        boolean isValid = true;

        // Perform validation checks using the Validator object
        if (!validator.isValidFirstName(_fname)) {
            wfname.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            wfname.setVisibility(View.GONE);
        }

        if (!validator.isValidLastName(_lname)) {
            wlname.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            wlname.setVisibility(View.GONE);
        }

        // Validate username
        if (!validator.isValidUsername(_uname)) {
            wuname.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            wuname.setVisibility(View.GONE);
        }

        // Validate password
        if (!validator.isValidPassword(_password)) {
            wpassword.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            wpassword.setVisibility(View.GONE);
        }

        // Validate email
        if (!validator.isValidEmail(_email)) {
            wemail.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            wemail.setVisibility(View.GONE);
        }

        if (userType.equals("supplier")) {
            if (!validator.isValidBusinessName(_bname)) {
                wbname.setVisibility(View.VISIBLE);
                isValid = false;
            } else {
                wbname.setVisibility(View.GONE);
            }
        }

        // Validate job code if user is Admin
        if (userType.equals("admin")) {
            if (!validator.isValidJobCode(_jobcode)) {
                wjobcode.setVisibility(View.VISIBLE);
                isValid = false;
            } else {
                wjobcode.setVisibility(View.GONE);
            }
        }


        return isValid;
    }


}