package com.example.tdq.as.myapplication;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button start,stop;
    private AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start =findViewById(R.id.startset);
        stop = findViewById(R.id.stopset);
        alarmManager = (AlarmManager)getSystemService(Service.ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this,AlarmService.class);
        pendingIntent = PendingIntent.getService(MainActivity.this,0,intent,0);
    }

    @SuppressLint("ResourceType")
    public void onClick(View view) throws IOException {
        switch (view.getId()){
            case R.id.startset:
                stratSetWallPager();
                break;
            case R.id.stopset:
                stopSetWallPager();
                break;
            default:break;
        }
    }

    public void stratSetWallPager(){
        start.setEnabled(false);
        stop.setEnabled(true);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,0,1000,pendingIntent);
    }

    public void stopSetWallPager(){
        start.setEnabled(true);
        stop.setEnabled(false);
        alarmManager.cancel(pendingIntent);

    }
}
