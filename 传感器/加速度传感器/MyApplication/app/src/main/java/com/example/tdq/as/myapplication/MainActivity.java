package com.example.tdq.as.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.text);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        StringBuffer sb = new StringBuffer();
        sb.append("X:");
        sb.append(values[0]);
        sb.append("\nY:");
        sb.append(values[1]);
        sb.append("\nZ:");
        sb.append(values[2]);
        editText.setText(sb.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
