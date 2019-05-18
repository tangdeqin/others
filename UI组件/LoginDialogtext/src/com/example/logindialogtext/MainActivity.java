package com.example.logindialogtext;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private Button bn ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bn = (Button)findViewById(R.id.button1);
		final Builder b = new AlertDialog.Builder(this);
		bn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b.setIcon(R.drawable.ic_launcher);
				b.setTitle("Login");
				LinearLayout layout = (LinearLayout)getLayoutInflater().inflate(R.layout.item, null);
				b.setView(layout);
				b.setPositiveButton("退出"
						// 为按钮设置监听器
						, new OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog, int which){
								//此处可执行登录处理
							}
			    });
				b.create().show();
			}
		});
	}
}
