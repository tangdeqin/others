package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
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
				// ���öԻ�����ʾ�ĵ�ѡ�б�
				final boolean status [] = {true,true,true}; 
				final String color[] = {"��","��","��"};
				builder.setMultiChoiceItems(new String[]{"��","��","��"}, status, new OnMultiChoiceClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						// TODO Auto-generated method stub
						TextView show = (TextView) findViewById(R.id.textView1);
						String chiose = "��ѡ�����ɫ��:";
						for(int i = 0;i < color.length;i++){
							if(status[i] == true){
								chiose += color[i];
							}
						show.setText(chiose);	
						}
					}
					
				});
				builder.setPositiveButton("�˳�", null);
				builder.create().show();
			}
		});		
	}
}
