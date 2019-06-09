package com.example.tdq.as.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextUserPassword;
    private CheckBox checkBoxRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername = findViewById(R.id.et_username);
        editTextUserPassword = findViewById(R.id.et_userpassword);
        checkBoxRemember = findViewById(R.id.cb_remember);
        editTextUsername.setText(SharedPreferencesWriteAndRead.ReadUsername(this));
        editTextUserPassword.setText(SharedPreferencesWriteAndRead.ReadPassword(this));
        checkBoxRemember.setChecked(SharedPreferencesWriteAndRead.ReadCheckBoxState(this));
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.cb_remember:
                setCheckBoxRemember();
                break;
            case R.id.bt_login:
                login();
                break;
            default:break;
        }
    }

    private void setCheckBoxRemember(){
        String userPassword = editTextUserPassword.getText().toString();
        String userName = editTextUsername.getText().toString();
        SharedPreferencesWriteAndRead.WriteCheckBoxState(this,checkBoxRemember.isChecked());
        if(checkBoxRemember.isChecked()){
            if(!userPassword.isEmpty()&&!userName.isEmpty()){
                if(checkBoxRemember.isChecked()){
                    SharedPreferencesWriteAndRead.WriteUsername(this,userName);
                    SharedPreferencesWriteAndRead.WriteUserPassword(this,userPassword);
                }
            }
        }else {
            SharedPreferencesWriteAndRead.WriteUsername(this,"");
            SharedPreferencesWriteAndRead.WriteUserPassword(this,"");
        }
    }
    private void login(){
        String userPassword = editTextUserPassword.getText().toString();
        String userName = editTextUsername.getText().toString();
        if(!userPassword.isEmpty()&&!userName.isEmpty()){
            Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
