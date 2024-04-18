package com.example.dealsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class C_homeScreen extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chome_screen);
        frameLayout = findViewById(R.id.main_frame);
        navBar = findViewById(R.id.nav_bar);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new F_Home()).commit();
        navBar.setSelectedItemId(R.id.home);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new F_Home()).commit();
                }
                else if(itemId == R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new User_details()).commit();
                }
                else if (itemId == R.id.deals) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new F_Availble_Deals()).commit();
                }

                return true;
            }
        });

    }
}
