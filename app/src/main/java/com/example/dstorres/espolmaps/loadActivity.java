package com.example.dstorres.espolmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class loadActivity extends AppCompatActivity {
    private static final long SPLASH_TME=4000 ;
    private Intent menuActivity= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                inicio();

            }
        };

        Timer timer =  new Timer();
        timer.schedule(task,SPLASH_TME);

    }

    public void inicio(){
        menuActivity = new Intent(this, MenuActivity.class);
        finish();
        startActivity(menuActivity);
    }
}
