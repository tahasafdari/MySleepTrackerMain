package com.example.mysleeptracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class start_activity extends AppCompatActivity {
    SharedPreferences tracking;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SharedPreferences tracking = getSharedPreferences("tracking", MODE_PRIVATE);

    }
}