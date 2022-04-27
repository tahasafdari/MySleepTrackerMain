package com.example.mysleeptracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button sleepButton, bedTimeGoalBtn;
    private TextView timeday;
    SharedPreferences tracking;
    SharedPreferences.Editor ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  tracking = PreferenceManager.getDefaultSharedPreferences(this);


        //setting up current date
        timeday = findViewById(R.id.timeday);
        Date currentlyDate = new Date();
        String stringDate = DateFormat.getDateInstance().format(currentlyDate);
        timeday.setText(stringDate);


        //calling the button id
        sleepButton = findViewById(R.id.sleepbtn);
        bedTimeGoalBtn = findViewById(R.id.bedTimeGoalBtn);

        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences tracking = getSharedPreferences("tracking", MODE_PRIVATE);
                ed = tracking.edit();

                Date storedate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");

                ed.putString("counting", formatter.format(storedate));
                ed.apply();

                Intent nightActivity = new Intent(MainActivity.this, night_activity.class);
                startActivity(nightActivity);

            }
        });

        bedTimeGoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bedtimeActivity = new Intent(MainActivity.this, bedtime_activity.class);
                startActivity(bedtimeActivity);
            }
        });


    }
}