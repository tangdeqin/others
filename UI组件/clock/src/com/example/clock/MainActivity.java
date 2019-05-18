package com.example.clock;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnChronometerTickListener {
	private Chronometer chronometer;
	private Button mstartButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	public void UIinit(){
		chronometer = (Chronometer)findViewById(R.id.chronometer);
		mstartButton = (Button)findViewById(R.id.button1);
		mstartButton.setOnClickListener(this);
		chronometer.setOnChronometerTickListener(this);
	}
	@Override
	public void onClick(View v) {
		chronometer.setBase(SystemClock.elapsedRealtime());
		chronometer.start();
	}
	@Override
	public void onChronometerTick(Chronometer chronometer) {
		if(SystemClock.elapsedRealtime()-chronometer.getBase() >= 20*1000){
			chronometer.stop();
			Toast.makeText(MainActivity.this, "Ê±¼äµ½£¡",Toast.LENGTH_SHORT).show();;
		}
	}
	
}
