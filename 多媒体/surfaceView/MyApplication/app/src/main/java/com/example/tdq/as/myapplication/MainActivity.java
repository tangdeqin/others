package com.example.tdq.as.myapplication;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SurfaceView surfaceView;
    int position=1;
    MediaPlayer mediaPlayer;

    Button start,pause,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        surfaceView = findViewById(R.id.surface);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new surfaceListener());
        start = findViewById(R.id.paly);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.paly:
                play();
                start.setEnabled(false);
                pause.setEnabled(true);
                stop.setEnabled(true);
                break;
            case R.id.pause:
                if(mediaPlayer.isPlaying()){
                    pause.setText("播放");
                    mediaPlayer.pause();
                }
                else {
                    pause.setText("暂停");
                    mediaPlayer.start();
                }
            case R.id.stop:

                if(mediaPlayer.isPlaying()){
                    stop.setEnabled(false);
                    start.setEnabled(true);
                    pause.setEnabled(false);
                    mediaPlayer.stop();
                }
        }
    }

    private  void play(){
        mediaPlayer.reset();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource("/storage/emulated/0/filename.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setDisplay(surfaceView.getHolder());
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public class surfaceListener implements SurfaceHolder.Callback{

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if(position>0){
                play();
                mediaPlayer.seekTo(position);
                position=0;
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            position = mediaPlayer.getCurrentPosition();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }
}
