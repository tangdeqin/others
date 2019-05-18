package com.example.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {
    private Button allselectButton,unallselectButton,sureButton;
    private CheckBox basketballCheckBox,pingpongCheckBox,badmintonCheckBox,swimmingCheckBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	public void UIinit(){
		allselectButton = (Button)findViewById(R.id.allselectbutton);
		unallselectButton = (Button)findViewById(R.id.unallselectbutton);
		sureButton = (Button)findViewById(R.id.surebutton);
		basketballCheckBox = (CheckBox)findViewById(R.id.checkbox1);
		pingpongCheckBox = (CheckBox)findViewById(R.id.checkbox2);
		badmintonCheckBox = (CheckBox)findViewById(R.id.checkbox3);
		swimmingCheckBox = (CheckBox)findViewById(R.id.checkbox4);
		
		allselectButton.setOnClickListener(this);
		unallselectButton.setOnClickListener(this);
		sureButton.setOnClickListener(this);
		
		basketballCheckBox.setOnCheckedChangeListener(this);
		pingpongCheckBox.setOnCheckedChangeListener(this);
		badmintonCheckBox.setOnCheckedChangeListener(this);
		swimmingCheckBox.setOnCheckedChangeListener(this);	
	}
	@Override
	public void onClick(View v) {
		String hobby = "你的爱好是：";
		switch(v.getId()){
		case R.id.allselectbutton:{
			basketballCheckBox.setChecked(true);
			pingpongCheckBox.setChecked(true);
			badmintonCheckBox.setChecked(true);
			swimmingCheckBox.setChecked(true); 			
			break;
		}
		case R.id.unallselectbutton:{
			if(basketballCheckBox.isChecked() && pingpongCheckBox.isChecked() && badmintonCheckBox.isChecked() && swimmingCheckBox.isChecked()){
				basketballCheckBox.setChecked(false);
				pingpongCheckBox.setChecked(false);
				badmintonCheckBox.setChecked(false);
				swimmingCheckBox.setChecked(false);
			}
	        break;
		}   
		case R.id.surebutton:{
			if(basketballCheckBox.isChecked()){
				hobby += basketballCheckBox.getText().toString();
			}
			if(pingpongCheckBox.isChecked()){
				hobby += " " + pingpongCheckBox.getText().toString();
			}
			if(badmintonCheckBox.isChecked()){
				hobby += " " + badmintonCheckBox.getText().toString();
			}
			if(swimmingCheckBox.isChecked()){
				hobby += " " + swimmingCheckBox.getText().toString();
			}
			if(!basketballCheckBox.isChecked()&&! pingpongCheckBox.isChecked() && !badmintonCheckBox.isChecked() &&! badmintonCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "你没有任何爱好", Toast.LENGTH_SHORT).show();
				break;
			}
			Toast.makeText(MainActivity.this, hobby, Toast.LENGTH_SHORT).show();
			break;
		}
	    default:break;
		}
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch(buttonView.getId()){
		case R.id.checkbox1:{
			if(basketballCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "选中篮球", Toast.LENGTH_SHORT).show();	
			}
			else if(!basketballCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "取消篮球", Toast.LENGTH_SHORT).show();	
			}
			break;
		}
		case R.id.checkbox2:{
			if(pingpongCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "选中乒乓球", Toast.LENGTH_SHORT).show();	
			}
			else if(!pingpongCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "取消乒乓球", Toast.LENGTH_SHORT).show();	
			}
			break;
		}
		case R.id.checkbox3:{
			if(badmintonCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "选中羽毛球", Toast.LENGTH_SHORT).show();	
			}
			else if(!badmintonCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "取消羽毛球", Toast.LENGTH_SHORT).show();	
			}
			break;
		}
		case R.id.checkbox4:{
			if(swimmingCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "选中游泳", Toast.LENGTH_SHORT).show();	
			}
			else if(!swimmingCheckBox.isChecked()){
				Toast.makeText(MainActivity.this, "取消游泳", Toast.LENGTH_SHORT).show();	
			}
			break;
		}
		default : break;
		}
	}
}
