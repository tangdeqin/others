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
		//����һ��AlertDialog.Builder����
		final Builder builder = new AlertDialog.Builder(this);
		//Ϊ��ť���¼�������
		bn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View source){
				// ���öԻ����ͼ��
				builder.setIcon(R.drawable.ic_launcher);
				// ���öԻ���ı���
				builder.setTitle("�Զ�����ͨ�Ի���");
				// ���öԻ�����ʾ���б�
				builder.setItems(new String[]{"��","��","��"}, new OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						TextView show = (TextView) findViewById(R.id.textView1);
						//which ָ�����б�����һ��
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
