package com.example.user.launcheractivitytest;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {
    Class<?> [] Classz = {SecondActivity.class,third.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] names = {"界面1","界面2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(this,Classz[position]);
    }
}
