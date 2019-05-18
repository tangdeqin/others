package org.crazyit.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerTest extends Activity
{
	String book[] = {"西游记","红楼梦","水浒传","三国演义"};
	private Spinner spinner;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		spinner = (Spinner)findViewById(R.id.spinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item,book);
		spinner.setAdapter(adapter);
		
	}
}