package com.example.listactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String arr[] = {"ÌÆÉ®","ËïÎò¿Õ","Öí°Ë½ä","É³É®"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
		setListAdapter(adapter);
	}
}
