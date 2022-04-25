package com.example.mysleeptracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button sleepButton, bedTimeGoalBtn;
    private TextView timeday;
    SharedPreferences tracking;
    SharedPreferences.Editor ed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                try {
                    SharedPreferences tracking = getSharedPreferences("tracking", MODE_PRIVATE);
                    ed = tracking.edit();
                    Date storeDate = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");

                    ed.putString("counting", formatter.format(storeDate));
                    ed.apply();


                    Intent nightActivity = new Intent(MainActivity.this, night_activity.class);
                    startActivity(nightActivity);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
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