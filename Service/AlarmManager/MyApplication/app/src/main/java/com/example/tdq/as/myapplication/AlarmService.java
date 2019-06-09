package com.example.tdq.as.myapplication;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by TDQ on 2019/6/8.
 */

public class AlarmService extends Service {
    WallpaperManager wallpaperManager;
    int[] picture = new int[]{R.drawable.picture1,R.drawable.picture2,R.drawable.picture3,R.drawable.picture4};
    int currentId = 0;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        wallpaperManager = WallpaperManager.getInstance(this);
    }

    @Override
    public void onStart(Intent intent ,int startid){
        super.onStart(intent,startid);
        if(currentId > 3){
            currentId=0;
        }
        try {
            wallpaperManager.setResource(picture[currentId++]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
