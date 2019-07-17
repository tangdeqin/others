package com.example.user.scrollertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);
        CustomView customView = findViewById(R.id.customview);
        customView.smoothScrollTo(-500,-500);
    }
}
