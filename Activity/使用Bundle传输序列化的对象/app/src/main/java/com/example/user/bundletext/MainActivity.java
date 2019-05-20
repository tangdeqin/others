package com.example.user.bundletext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person("deqin","20");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,secondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("person",person);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
