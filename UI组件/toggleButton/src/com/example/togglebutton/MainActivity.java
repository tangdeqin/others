package com.example.togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener {
    private ToggleButton selectToggleButton;
	private LinearLayout testLinearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	
	public void UIinit(){
		selectToggleButton = (ToggleButton)findViewById(R.id.selecttogglebutton);
		testLinearLayout = (LinearLayout)findViewById(R.id.test);
		selectToggleButton.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(isChecked){
			testLinearLayout.setOrientation(0);
		}
		else{
			testLinearLayout.setOrientation(1);
		}
	}

}
