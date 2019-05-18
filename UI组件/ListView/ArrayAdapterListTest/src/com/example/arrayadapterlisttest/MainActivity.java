package com.example.arrayadapterlisttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	public void UIinit(){
		String arr[] = {"ËïÎò¿Õ","Öí°Ë½ä","É³É®","ÌÆÉ®"};
		listview = (ListView)findViewById(R.id.listView2);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arr);
		listview.setAdapter(adapter);
	}

}
