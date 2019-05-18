package com.example.tabhost;


import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();
		//����ʹ��TabHost����
		LayoutInflater.from(this).inflate(R.layout.activity_main,
				tabHost.getTabContentView(), true);
		//��ӵ�һ����ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("���μ�")
			.setContent(R.id.tab01)); 
		//��ӵڶ�����ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab2")
			//�ڱ�ǩ�����Ϸ���ͼ��
			.setIndicator("��¥��" 
				, getResources().getDrawable(R.drawable.ic_launcher))
			.setContent(R.id.tab02)); 
		//��ӵ�������ǩҳ
		tabHost.addTab(tabHost.newTabSpec("tab3")
			.setIndicator("ˮ䰴�")
			.setContent(R.id.tab03)); 			
	}
}
