package com.example.mysleeptracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class stat_activity extends AppCompatActivity {
    Button backToHome;
    SharedPreferences tracking;
    SharedPreferences.Editor ed;
    TextView dateStat, wentToSleep, wakeUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        initUI();
        getStatus();


        backToHome = findViewById(R.id.backtohome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backToMainActivity = new Intent(stat_activity.this, MainActivity.class);
                startActivity(backToMainActivity);
            }
        });
    }

    private void getStatus(){
        SharedPreferences tracking = getSharedPreferences("tracking", MODE_PRIVATE);
        ed = tracking.edit();
        Date currentDate = new Date();
        dateStat.setText(DateFormat.getDateInstance().format(currentDate));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
        SimpleDateFormat displayTime = new SimpleDateFormat("HH:mm:ss");
        try {
            Date storeDate = formatter.parse(tracking.getString("counting", formatter.format(currentDate)));

            wentToSleep.setText(displayTime.format(storeDate));
            wakeUp.setText(displayTime.format(currentDate));

            ed.remove("counting");
            ed.apply();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void initUI() {
        dateStat = findViewById(R.id.datestat);
        wentToSleep = findViewById(R.id.wenttosleep);
        wakeUp = findViewById(R.id.wakeup);

    }
}