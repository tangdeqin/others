package com.example.textview;

import java.text.DateFormat.Field;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tvRunLamp;
	private TextView textView1;
    private TextView textViewImg;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		   tvRunLamp = (TextView) findViewById(R.id.tvRunLamp);
		   String html = "之前讲解Android布局的时候，就已经说明，所有<a href='http://www.cnblogs.com/plokmju/p/androidUI_Layout.html'>Layout</a>都是View的子类或者间接子类。而TextView也一样，是View的直接子类。它是一个文本显示控件，提供了基本的显示文本的功能，并且是大部分UI控件的父类，因为大部分UI控件都需要展示信息。";
		   CharSequence cs = Html.fromHtml(html);
		   tvRunLamp.setText(cs);
		   //因为文本中设定了一个<a>标签，这里设置响应。
		   tvRunLamp.setMovementMethod(LinkMovementMethod.getInstance());
		   
		   //设置需要显示的字符串
		  textView1=(TextView)findViewById(R.id.textView1);
		  String htm2="<font color ='red'>Hello android</font><br/>";
		   htm2+="<font color='#0000ff'><big><i>Hello android</i></big></font><br/>";
		  htm2+="<big><a href='http://www.baidu.com'>百度</a></big>";
		   //使用Html.fromHtml,把含HTML标签的字符串转换成可显示的文本样式
		   CharSequence charSequence=Html.fromHtml(htm2);
		    //通过setText给TextView赋值
		  textView1.setText(charSequence);
		   //设定一个点击的响应
		  textView1.setMovementMethod(LinkMovementMethod.getInstance());
		  
		
		  textViewImg=(TextView)findViewById(R.id.textImg);

		  //设定HTML标签样式，图片3为一个超链接标签a
		   String htm3="<img src='image1'/><img src='image2'/>";
		  htm3+="<a href='http://www,baidu.com'><img src='ic_launcher'/></a>";
		  //fromHtml中ImageGetter选择html中<img>的图片资源
		        CharSequence cs1=Html.fromHtml(htm3, new ImageGetter() {
		           
		            public Drawable getDrawable(String source) {
		                 //source为html字符串中定义的<img>中的src的内容
		                 //返回值Drawable就是对应的<img>显示的图片资源
		                Drawable draw=null;
		               if(source.equals("image1"))
		              {
		                     draw=getResources().getDrawable(R.drawable.ic_launcher);
		                    draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
		                }
		                else if(source.equals("image2"))
		               {
		                 //设定image2尺寸等比缩小
		                    draw=getResources().getDrawable(R.drawable.ic_launcher);
		                     draw.setBounds(0, 0, draw.getIntrinsicWidth()/2, draw.getIntrinsicHeight()/2);
		              }
		               else
		               {
		                   //使用反射会更简便，无需知道src与资源Id的对应关系
		                    draw=getResources().getDrawable(getResourceId(source));
		                    draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
		                 }
		                 return draw;
		             }
		         }, null);
		         textViewImg.setText(cs1);
		         textViewImg.setMovementMethod(LinkMovementMethod.getInstance());
		    }
		     
		     public int getResourceId(String source){
		       try {
		           //使用反射机制，通过属性名称，得到其内的值
		           java.lang.reflect.Field field=R.drawable.class.getField(source);
		            return Integer.parseInt(field.get(null).toString());
		        } 
		       catch (Exception e) {
		           // TODO: handle exception
		       }
		          return 0;
		     }
		    
		  
	
}
