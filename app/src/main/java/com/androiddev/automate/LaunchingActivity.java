package com.androiddev.automate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddev.automate.LoginActivity;
import com.androiddev.automate.MainActivity;
import com.androiddev.automate.R;
import com.androiddev.automate.RegistrationActivity;

public class LaunchingActivity extends AppCompatActivity {

    Button signin,signup;

    SharedPreferences sharedPreferences;

    public static final String fileName = "login";
    public static final String Email = "email";
    public static final String Password = "password";
    public static final String Name = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);

        sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(Email)){
            Intent intent = new Intent(LaunchingActivity.this, MainActivity.class);
            startActivity(intent);
            finishAffinity();
        }

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaunchingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaunchingActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });


    }
}