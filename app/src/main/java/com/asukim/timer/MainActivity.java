package com.asukim.timer;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int timerSec;
    int count;
    private TimerTask second;
    private TextView timerText;
    private final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = (TextView) findViewById(R.id.timer);

        Button startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerStart();
            }
        });
    }

    public void timerStart() {
        timerSec = 0;
        count = 0;

        second = new TimerTask() {

            @Override
            public void run() {
                Log.i("Test", "Timer start");
                timerUpdate();
                timerSec++;
            }
        };
        Timer timer = new Timer();

        //timer라는 TimerTask를 선언하고 시작, 딜레이 0초, 1초마다 반복복
       timer.schedule(second, 0, 1000);
    }

    protected void timerUpdate() {
        Runnable updater = new Runnable() {
            public void run() {
                timerText.setText(timerSec + "초");
            }
        };
        handler.post(updater);
    }
}