package com.example.tdq.as.myapplication;

import android.app.AlarmManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    SoundPool soundPool;
    Map<Integer,Integer> soundMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,5);
        soundMap.put(1,soundPool.load(this,R.raw.bells,1));
        soundMap.put(2,soundPool.load(this,R.raw.code,1));
        soundMap.put(3,soundPool.load(this,R.raw.complete,1));
        soundMap.put(4,soundPool.load(this,R.raw.gemi,1));
        soundMap.put(5,soundPool.load(this,R.raw.guitar,1));
        soundMap.put(6,soundPool.load(this,R.raw.microtri,1));
        soundMap.put(7,soundPool.load(this,R.raw.paint,1));
        soundMap.put(8,soundPool.load(this,R.raw.popup,1));
        soundMap.put(9,soundPool.load(this,R.raw.success,1));
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt1:
                soundPool.play(soundMap.get(1),1,1,0,0,1);
                break;
            case R.id.bt2:
                soundPool.play(soundMap.get(2),1,1,0,0,1);
                break;
            case R.id.bt3:
                soundPool.play(soundMap.get(3),1,1,0,0,1);
                break;

            case R.id.bt4:
                soundPool.play(soundMap.get(4),1,1,0,0,1);
                break;
            case R.id.bt5:
                soundPool.play(soundMap.get(5),1,1,0,0,1);
                break;
            case R.id.bt6:
                soundPool.play(soundMap.get(6),1,1,0,0,1);
                break;
            case R.id.bt7:
                soundPool.play(soundMap.get(7),1,1,0,0,1);
                break;
            case R.id.bt8:
                soundPool.play(soundMap.get(8),1,1,0,0,1);
                break;
            case R.id.bt9:
                soundPool.play(soundMap.get(9),1,1,0,0,1);
                break;
        }
    }
}
