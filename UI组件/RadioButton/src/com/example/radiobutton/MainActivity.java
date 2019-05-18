package com.example.radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {
    private RadioGroup sexRadioGroup;
    private Button mOkButton;
    private TextView displayTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	
	public void UIinit(){
		sexRadioGroup = (RadioGroup)findViewById(R.id.sex_select);
		mOkButton = (Button)findViewById(R.id.button1);
		mOkButton.setOnClickListener(this);
		sexRadioGroup.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		int sexselect = sexRadioGroup.getCheckedRadioButtonId();
		if(sexselect == R.id.man){
			 Toast.makeText(MainActivity.this,"性别是:男",Toast.LENGTH_SHORT).show();
		}
		else if(sexselect == R.id.woman){
			 Toast.makeText(MainActivity.this,"性别是:女",Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		displayTextView = (TextView)findViewById(R.id.textView1);
		int sexselect = sexRadioGroup.getCheckedRadioButtonId();
		if(sexselect == R.id.man){
			displayTextView.setText("您的性别是：男");
		}
		else{
			displayTextView.setText("您的性别是：女");
		}
	}
}
