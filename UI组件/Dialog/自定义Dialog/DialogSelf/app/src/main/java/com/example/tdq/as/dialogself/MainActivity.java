package com.example.tdq.as.dialogself;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String ACTION = "getLoginUesrname";
    private TextView UsernameTv;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ACTION)){
                UsernameTv.setText(intent.getStringExtra("Uesrname").toString());
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameTv = findViewById(R.id.tv_username);

        DialogSelf dialogSelf = new DialogSelf(this);
        dialogSelf.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION);
        registerReceiver(broadcastReceiver,intentFilter);
    }
}
