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
		
		//��ȡ��ǰ�����ڣ�����DatePicker�ĳ�ʼ��
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		mon = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		min = calendar.get(Calendar.MINUTE);
		
		datepicker = (DatePicker)findViewById(R.id.datepicker);
		//datepicker�ļ����¼��������ڱ仯ʱ���༭����Ӧ�ĸı�
		datepicker.init(year , mon ,day , new OnDateChangedListener(){
				@Override
				public void onDateChanged(DatePicker arg0, int year, int mon, int day)
				{
		
					//��ʾ��ǰ���ڡ�ʱ��
					showtime(year, mon , day , hour, min);
				}
		});
		
		timepicker = (TimePicker)findViewById(R.id.timepicker);
		//ΪTimePickerָ��������
		timepicker.setOnTimeChangedListener(new OnTimeChangedListener()
			{
				@Override
				public void onTimeChanged(TimePicker arg0, int hour, int min)
				{
					MainActivity.this.hour = hour;
					MainActivity.this.min = min;
					//��ʾ��ǰ���ڡ�ʱ��
					showtime(year, mon , day , hour, min);				
				}
			});	
	}

	

	//�ڱ༭������ʾ�޸ĵ�����
	private void showtime(int year,int mon,int day,int hour,int min){
		EditText showtimeEidtText = (EditText)findViewById(R.id.show);
		String showtimestring = "�㹺��������ǣ�"+year+"��"+mon+"��"+day+"��"+hour+"ʱ"+min+"��";
		showtimeEidtText.setText(showtimestring);
		
	}
}
