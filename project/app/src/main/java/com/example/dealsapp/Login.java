package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btlogin;
    String _username, _password;
    TextView wusername, wpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //loginInput();
        //loginAlert();
        handleLoginButton();

    }
    public void loginInput(){
        username = findViewById(R.id.tbUsername_login);
        password = findViewById(R.id.tbPassword_login);
        _username = username.getText().toString();
        _password = password.getText().toString();
    }
    public void loginAlert(){
        wusername = findViewById(R.id.wlb_uname);
        wpassword = findViewById(R.id.wlb_password);
    }
    public void handleLoginButton(){
        btlogin = findViewById(R.id.btLogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginInput();
                boolean checkLogin = validateLogin();
                if(checkLogin){
                    Intent intent = new Intent(Login.this, C_homeScreen.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "invalid credentials or user don't exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validateLogin(){
        boolean isValid = true;

        UserManager userManager = UserManager.getInstance();

        if (!userManager.isValidLogin(_username, _password)) {
            isValid = false;
        }

        return isValid;
    }

}