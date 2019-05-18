package com.example.simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	public void UIinit(){
		String names[] = {"西游记","红楼梦","水浒传","三国演义"};
		String mans[] = {"孙悟空","贾宝玉","宋江","诸葛亮"};
		int images[] = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		listview =(ListView)findViewById(R.id.listView1);
		List<Map<String,Object>> listitems = new ArrayList<Map<String,Object>>();
		for(int i =0 ;i < names.length;i++){
			Map<String,Object> listitem = new HashMap<String,Object>();
			listitem.put("image",images[i]);
			listitem.put("name", names[i]);
			listitem.put("man", mans[i]);
			listitems.add(listitem);
		}
		
		SimpleAdapter simepleadapter = new SimpleAdapter(this,listitems, R.layout.item, 
				                                          new String[]{"image","name","man"}, new int[]{R.id.imageview,R.id.textView1,R.id.textView2});
		listview.setAdapter(simepleadapter);
	}
}
