package com.example.tdq.as.myapplication;

import android.app.Service;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator)getSystemService(Service.VIBRATOR_SERVICE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //vibrator.vibrate(2000);
        long[] patt = new long[]{100,200,300,1000};
        vibrator.vibrate(patt,0);
        //vibrator.cancel();
        return super.onTouchEvent(event);
    }
}
