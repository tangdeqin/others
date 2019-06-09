package com.example.tdq.as.myapplication;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt1:
            play1();
            break;
            case R.id.bt2:
                play2();
                break;
            case R.id.bt3:
                play3();
                break;
            case R.id.bt4:
                play4();
                break;
            default:break;
        }
    }

    private void play4() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse("http://www.crazyit.org/abc.mp3");
        try {
            mediaPlayer.setDataSource(this,uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void play3() {
        MediaPlayer mediaPlayer  = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("/storage/emulated/0/storage/emulated/0/musicqq.m4a");
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void play2() {
        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd("music.m4a");
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),assetFileDescriptor.getStartOffset(),assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play1(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.music);
        mediaPlayer.start();
    }
}
