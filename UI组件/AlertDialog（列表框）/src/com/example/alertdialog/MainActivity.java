package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.button1);
		//定义一个AlertDialog.Builder对象
		final Builder builder = new AlertDialog.Builder(this);
		//为按钮绑定事件监听器
		bn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View source){
				// 设置对话框的图标
				builder.setIcon(R.drawable.ic_launcher);
				// 设置对话框的标题
				builder.setTitle("自定义普通对话框");
				// 设置对话框显示的列表
				builder.setItems(new String[]{"红","绿","蓝"}, new OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						TextView show = (TextView) findViewById(R.id.textView1);
						//which 指按下列表中那一行
						switch(which){
						case 0:{
							show.setBackgroundColor(Color.RED);
							break;
						}
						case 1:{
							show.setBackgroundColor(Color.GREEN);
							break;
						}
						case 2:{
							show.setBackgroundColor(Color.BLUE);
							break;
						}
						default :break;
						}
					}
					
				});
				builder.create().show();
			}
		});		
	}
}
