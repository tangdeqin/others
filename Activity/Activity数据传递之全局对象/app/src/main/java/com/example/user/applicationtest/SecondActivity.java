package com.example.user.applicationtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by user on 19-5-20.
 */

public class SecondActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.second);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,MyApplication.getMap().get("name")+MyApplication.getMap().get("age"),Toast.LENGTH_LONG).show();
    }
}
