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

public class stat_activity extends AppCompatActivity {
    Button backToHome;
    SharedPreferences tracking;
    SharedPreferences.Editor ed;
    TextView dateStat, wentToSleep, wakeUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        statSet();
        initUI();

        backToHome = findViewById(R.id.backtohome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainActivity = new Intent(stat_activity.this, MainActivity.class);
                startActivity(backToMainActivity);
            }
        });
    }



    public void statSet() {
        SharedPreferences tracking = getSharedPreferences("tracking", MODE_PRIVATE);
        ed = tracking.edit();

        dateStat = findViewById(R.id.datestat);
        Date curDate = new Date();
        dateStat.setText(DateFormat.getDateInstance().format(curDate));


    }
    public void initUI() {
        dateStat = findViewById(R.id.datestat);
        wentToSleep = findViewById(R.id.wenttosleep);
        wakeUp = findViewById(R.id.wakeup);

    }
}