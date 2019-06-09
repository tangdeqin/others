package com.example.tdq.as.myapplication;

import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;
    private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager)getSystemService(Service.AUDIO_SERVICE);
        toggleButton =findViewById(R.id.mute);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                audioManager.setStreamMute(AudioManager.STREAM_MUSIC,b);
            }
        });
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.paly:
                palyMusic();
                break;
            case R.id.up:
                upMusic();
                break;
            case R.id.down:
                downMusic();
                break;
        }
    }

    public void palyMusic(){
        MediaPlayer player = MediaPlayer.create(MainActivity.this,R.raw.music);
        player.setLooping(true);
        player.start();
    }

    public void upMusic(){
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);
    }
    public void downMusic(){
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);
    }
}
