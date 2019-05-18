package com.example.choosetime;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
	private DatePicker datepicker;
	private TimePicker timepicker;
	private int year,mon,day,hour,min;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//获取当前的日期，用于DatePicker的初始化
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		mon = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		min = calendar.get(Calendar.MINUTE);
		
		datepicker = (DatePicker)findViewById(R.id.datepicker);
		//datepicker的监听事件，当日期变化时，编辑框相应的改变
		datepicker.init(year , mon ,day , new OnDateChangedListener(){
				@Override
				public void onDateChanged(DatePicker arg0, int year, int mon, int day)
				{
		
					//显示当前日期、时间
					showtime(year, mon , day , hour, min);
				}
		});
		
		timepicker = (TimePicker)findViewById(R.id.timepicker);
		//为TimePicker指定监听器
		timepicker.setOnTimeChangedListener(new OnTimeChangedListener()
			{
				@Override
				public void onTimeChanged(TimePicker arg0, int hour, int min)
				{
					MainActivity.this.hour = hour;
					MainActivity.this.min = min;
					//显示当前日期、时间
					showtime(year, mon , day , hour, min);				
				}
			});	
	}

	

	//在编辑框中显示修改的日期
	private void showtime(int year,int mon,int day,int hour,int min){
		EditText showtimeEidtText = (EditText)findViewById(R.id.show);
		String showtimestring = "你购买的日期是："+year+"年"+mon+"月"+day+"日"+hour+"时"+min+"秒";
		showtimeEidtText.setText(showtimestring);
		
	}
}
