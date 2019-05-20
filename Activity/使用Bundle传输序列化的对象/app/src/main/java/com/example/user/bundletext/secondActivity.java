package com.example.user.bundletext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by user on 19-5-20.
 */

public class secondActivity extends Activity {
    private TextView showNameTextView,showAgeTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        showNameTextView = findViewById(R.id.tv_name);
        showAgeTextView = findViewById(R.id.tv_age);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Person person = (Person) bundle.getParcelable("person");
        showNameTextView.setText(person.getName());
        showAgeTextView.setText(person.getAge());
    }
}
