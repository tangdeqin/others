package com.example.tdq.as.dialogself;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TDQ on 2019/5/25.
 */

public class DialogSelf extends Dialog {
    private EditText UesrnameEt;
    private Button CancelButton,SureButton;
    public DialogSelf(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogmyself);
        UesrnameEt = findViewById(R.id.et_username);
        CancelButton = findViewById(R.id.bt_cancel);
        SureButton = findViewById(R.id.bt_sure);

        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        SureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MainActivity.ACTION);
                intent.putExtra("Uesrname",UesrnameEt.getText().toString());
                getContext().sendBroadcast(intent);
                dismiss();
            }
        });
    }
}
