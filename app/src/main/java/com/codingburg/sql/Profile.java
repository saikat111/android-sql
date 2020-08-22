package com.codingburg.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView name, emal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.name);
        emal = findViewById(R.id.email);
        if(!SharedPrefarenceManager.getInstance(this).isLoggedin()){
            finish();
            startActivity(new Intent(this, Login.class));
        }
        name.setText(SharedPrefarenceManager.getInstance(this).getName());
        name.setText(SharedPrefarenceManager.getInstance(this).getEmail());
    }
}