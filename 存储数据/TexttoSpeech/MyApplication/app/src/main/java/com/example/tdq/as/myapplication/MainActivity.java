package com.example.tdq.as.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private EditText editTextSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextSpeech = findViewById(R.id.et_speech);
        textToSpeech = new TextToSpeech(this,new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                    if (!(result==TextToSpeech.LANG_AVAILABLE && result==TextToSpeech.LANG_COUNTRY_AVAILABLE)){
                        Toast.makeText(MainActivity.this,"tts不支持该语言",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void onClick(View view){
        String speech = editTextSpeech.getText().toString();
        switch (view.getId()){
            case R.id.bt_speech:
                if(!speech.isEmpty()){
                    textToSpeech.speak(speech,TextToSpeech.QUEUE_ADD,null);
                }
                break;
            case R.id.bt_record:
                if(!speech.isEmpty()){
                    textToSpeech.synthesizeToFile(speech,null,"/mnt/sdcard/speech.wav");
                    Toast.makeText(MainActivity.this,"录制成功",Toast.LENGTH_SHORT).show();
                }
                break;
            default:break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech!=null){
            textToSpeech.shutdown();
        }
    }
}
