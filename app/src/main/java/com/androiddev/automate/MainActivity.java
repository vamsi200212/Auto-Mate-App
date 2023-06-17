package com.androiddev.automate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    static BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,new HomeFragment(),"HomeFragment")
                .addToBackStack("HomeFragment")
                .commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new HomeFragment(),"HomeFragment")
                            .addToBackStack("HomeFragment")
                            .commit();
                    return true;
                case R.id.fuel:
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new PetrolStationsFragment(),"PetrolFragment")
                            .addToBackStack("PetrolFragment")
                            .commit();
                    return true;
                case R.id.electric:
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new EVStationsFragment(),"EVStationsFragment")
                            .addToBackStack("EVStationsFragment")
                            .commit();
                    return true;
                case R.id.profile:
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new ProfileFragment(),"ProfileFragment")
                            .addToBackStack("ProfileFragment")
                            .commit();
                    return true;
                case R.id.speed:
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new SpeedometerFragment(),"SpeedometerFragment")
                            .addToBackStack("SpeedometerFragment")
                            .commit();
                    return true;
            }
            return false;
        });
    }
}