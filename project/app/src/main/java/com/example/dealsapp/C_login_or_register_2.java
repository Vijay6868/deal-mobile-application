package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class C_login_or_register_2 extends AppCompatActivity {
    Button btCustomer, btSupplier, btAdmin;
    TextView tvClickHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clogin_or_register2);

        btCustomer = findViewById(R.id.btCustomer);
        btSupplier = findViewById(R.id.btSupplier);
        btAdmin = findViewById(R.id.btAdmin);
        tvClickHere = findViewById(R.id.tv_already_have_account_click_here);

        tvClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(C_login_or_register_2.this, Login.class);
                startActivity(intent);
            }
        });

        // Set click listeners for the buttons
        btCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Login activity and pass user type as an extra
                Intent intent = new Intent(C_login_or_register_2.this, C_Registration.class);
                intent.putExtra("userType", "customer");
                startActivity(intent);
            }
        });

        btSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Login activity and pass user type as an extra
                Intent intent = new Intent(C_login_or_register_2.this, C_Registration.class);
                intent.putExtra("userType", "supplier");
                startActivity(intent);
            }
        });

        btAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Login activity and pass user type as an extra
                Intent intent = new Intent(C_login_or_register_2.this, C_Registration.class);
                intent.putExtra("userType", "admin");
                startActivity(intent);
            }
        });
    }
}