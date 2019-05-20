package com.example.user.applicationtest;

import android.app.Application;

import java.util.HashMap;

/**
 * Created by user on 19-5-20.
 */

public class MyApplication extends Application {
    public static HashMap<String,String> map = new HashMap<>();

    public static HashMap<String,String> getMap(){
        return  map;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
