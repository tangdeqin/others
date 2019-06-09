package com.example.tdq.as.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
    public static final String TEXTNAME = "text.txt";
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.et_one);
        editText2 = findViewById(R.id.et_two);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_write:
                String string = editText1.getText().toString();
                if(!string.isEmpty()){
                    write(string);
                }
                editText1.setText("");
                break;
            case R.id.bt_read:
                editText2.setText(read());
        }
    }

    private void write(String string) {
        try {
            //以追加的方式打开(默认路径在当前的程序包下)
            FileOutputStream fs = openFileOutput(TEXTNAME,MODE_APPEND);
            PrintStream printStream = new PrintStream(fs);
            printStream.print(string);
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String read() {
        try {
            FileInputStream  inputStream = openFileInput(TEXTNAME);
            byte[] buff = new byte[2018];
            int len = inputStream.read(buff);
            String string = new String(buff,0,len);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
