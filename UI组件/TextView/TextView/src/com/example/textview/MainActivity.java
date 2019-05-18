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
		   String html = "֮ǰ����Android���ֵ�ʱ�򣬾��Ѿ�˵��������<a href='http://www.cnblogs.com/plokmju/p/androidUI_Layout.html'>Layout</a>����View��������߼�����ࡣ��TextViewҲһ������View��ֱ�����ࡣ����һ���ı���ʾ�ؼ����ṩ�˻�������ʾ�ı��Ĺ��ܣ������Ǵ󲿷�UI�ؼ��ĸ��࣬��Ϊ�󲿷�UI�ؼ�����Ҫչʾ��Ϣ��";
		   CharSequence cs = Html.fromHtml(html);
		   tvRunLamp.setText(cs);
		   //��Ϊ�ı����趨��һ��<a>��ǩ������������Ӧ��
		   tvRunLamp.setMovementMethod(LinkMovementMethod.getInstance());
		   
		   //������Ҫ��ʾ���ַ���
		  textView1=(TextView)findViewById(R.id.textView1);
		  String htm2="<font color ='red'>Hello android</font><br/>";
		   htm2+="<font color='#0000ff'><big><i>Hello android</i></big></font><br/>";
		  htm2+="<big><a href='http://www.baidu.com'>�ٶ�</a></big>";
		   //ʹ��Html.fromHtml,�Ѻ�HTML��ǩ���ַ���ת���ɿ���ʾ���ı���ʽ
		   CharSequence charSequence=Html.fromHtml(htm2);
		    //ͨ��setText��TextView��ֵ
		  textView1.setText(charSequence);
		   //�趨һ���������Ӧ
		  textView1.setMovementMethod(LinkMovementMethod.getInstance());
		  
		
		  textViewImg=(TextView)findViewById(R.id.textImg);

		  //�趨HTML��ǩ��ʽ��ͼƬ3Ϊһ�������ӱ�ǩa
		   String htm3="<img src='image1'/><img src='image2'/>";
		  htm3+="<a href='http://www,baidu.com'><img src='ic_launcher'/></a>";
		  //fromHtml��ImageGetterѡ��html��<img>��ͼƬ��Դ
		        CharSequence cs1=Html.fromHtml(htm3, new ImageGetter() {
		           
		            public Drawable getDrawable(String source) {
		                 //sourceΪhtml�ַ����ж����<img>�е�src������
		                 //����ֵDrawable���Ƕ�Ӧ��<img>��ʾ��ͼƬ��Դ
		                Drawable draw=null;
		               if(source.equals("image1"))
		              {
		                     draw=getResources().getDrawable(R.drawable.ic_launcher);
		                    draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
		                }
		                else if(source.equals("image2"))
		               {
		                 //�趨image2�ߴ�ȱ���С
		                    draw=getResources().getDrawable(R.drawable.ic_launcher);
		                     draw.setBounds(0, 0, draw.getIntrinsicWidth()/2, draw.getIntrinsicHeight()/2);
		              }
		               else
		               {
		                   //ʹ�÷�������㣬����֪��src����ԴId�Ķ�Ӧ��ϵ
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
		           //ʹ�÷�����ƣ�ͨ���������ƣ��õ����ڵ�ֵ
		           java.lang.reflect.Field field=R.drawable.class.getField(source);
		            return Integer.parseInt(field.get(null).toString());
		        } 
		       catch (Exception e) {
		           // TODO: handle exception
		       }
		          return 0;
		     }
		    
		  
	
}
