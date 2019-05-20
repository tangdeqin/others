package com.example.user.listactivitytest;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListActivityTest extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arr = {"唐僧","孙悟空","猪八戒","沙和尚","白龙马"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        setListAdapter(adapter);
    }
}
