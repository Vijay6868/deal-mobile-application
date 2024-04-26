package com.example.dealsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btCustomer, btSupplier, btAdmin;
    TextView tvClickHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCustomer = findViewById(R.id.btCustomer);
        btSupplier = findViewById(R.id.btSupplier);
        btAdmin = findViewById(R.id.btAdmin);
        tvClickHere = findViewById(R.id.tv_already_have_account_click_here);

        tvClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, C_login_or_register_2.class);
                startActivity(intent);
            }
        });

        // Set click listeners for the buttons
        btCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Login activity and pass user type as an extra
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("userType", "customer");
                startActivity(intent);
            }
        });

        btSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Login activity and pass user type as an extra
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("userType", "supplier");
                startActivity(intent);
            }
        });

        btAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Login activity and pass user type as an extra
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("userType", "admin");
                startActivity(intent);
            }
        });
    }
}
