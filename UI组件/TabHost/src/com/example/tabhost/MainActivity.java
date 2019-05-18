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
		//设置使用TabHost布局
		LayoutInflater.from(this).inflate(R.layout.activity_main,
				tabHost.getTabContentView(), true);
		//添加第一个标签页
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("西游记")
			.setContent(R.id.tab01)); 
		//添加第二个标签页
		tabHost.addTab(tabHost.newTabSpec("tab2")
			//在标签标题上放置图标
			.setIndicator("红楼梦" 
				, getResources().getDrawable(R.drawable.ic_launcher))
			.setContent(R.id.tab02)); 
		//添加第三个标签页
		tabHost.addTab(tabHost.newTabSpec("tab3")
			.setIndicator("水浒传")
			.setContent(R.id.tab03)); 			
	}
}
