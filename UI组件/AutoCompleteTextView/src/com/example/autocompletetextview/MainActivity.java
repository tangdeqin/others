package com.example.autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
    String books[] = {"西游记","红楼梦","水浒传","三国演义" };
    private AutoCompleteTextView v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		v = (AutoCompleteTextView)findViewById(R.id.auto);
		ArrayAdapter<String> ss = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
		v.setAdapter(ss);
		

	}
}
