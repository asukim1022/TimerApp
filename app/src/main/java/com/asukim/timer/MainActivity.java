package com.asukim.timer;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int timer_sec;
    int count;
    private TimerTask second;
    private TextView timer_text;
    private final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerStart();
    }

    public void timerStart() {
        timer_text = (TextView) findViewById(R.id.timer);
        timer_sec = 0;
        count = 0;

        second = new TimerTask() {

            @Override
            public void run() {
                Log.i("Test", "Timer start");
                timerUpdate();
                timer_sec++;
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 0, 1000);
    }

    protected void timerUpdate() {
        Runnable updater = new Runnable() {
            public void run() {
                timer_text.setText(timer_sec + "초");
            }
        };
        handler.post(updater);
    }
}