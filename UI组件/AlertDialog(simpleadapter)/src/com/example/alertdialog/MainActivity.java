package com.example.alertdialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends Activity{
	final int LIST_DIALOG = 0x11;
	private String booksname[] = {"西游记","红楼梦","水浒传"};
	private int booksimage[] = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button)findViewById(R.id.button1);
		//为按钮绑定事件监听器
		bn.setOnClickListener(new View.OnClickListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View source){
				//显示对话框
				showDialog(LIST_DIALOG);
			}
		});		
	}
	@Override
	//重写方法创建对话框
	public Dialog onCreateDialog(int id,Bundle state){
		switch(id){
		case LIST_DIALOG:{
			android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setIcon(R.drawable.ic_launcher);
			builder.setTitle("名著");
			//创建List集合，
			List<Map<String,Object>> listitems = new ArrayList<Map<String,Object>>();
			for(int i = 0;i < booksname.length;i++){
				Map<String,Object> listitem = new HashMap<String,Object>();
				listitem.put("header", booksimage[i]);
				listitem.put("bookname", booksname[i]);
				listitems.add(listitem);
			}
	        SimpleAdapter simpleadapter = new SimpleAdapter(this,listitems,R.layout.item, 
	        		                                        new String[]{"header","bookname"}, new int[]{R.id.imageView1,R.id.textView1});
	        builder.setAdapter(simpleadapter, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					TextView show = (TextView)findViewById(R.id.textView2);
					show.setText("你喜欢的名著："+booksname[which]);
				}
			});
	        return builder.create();
		}
		}
		return null;
	}
}

