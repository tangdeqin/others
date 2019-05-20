package com.example.user.expandablelistactivitytest;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends ExpandableListActivity {

    String[] groups = {"常见问题", "功能帮助", "其他帮助"};
    String[][] children = {
            {"常见问题1", "常见问题2", "常见问题3"},
            {"功能问题1", "功能问题2", "功能问题3"},
            {"其他问题1", "其他问题2", "其他问题3"},
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            @Override
            public int getGroupCount() {
                return groups.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return children[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return groups[i];
            }

            @Override
            public Object getChild(int i, int i2) {
                return children[i][i2];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i2) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }


            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.ground, null);
                TextView title = (TextView) view1.findViewById(R.id.groupTo);
                title.setText(groups[i]);
                return view1;
            }

            @Override
            public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
                View view1 =  LayoutInflater.from(MainActivity.this).inflate(R.layout.child, null);
                TextView title = (TextView) view1.findViewById(R.id.childTo);
                title.setText(children[i][i2]);
                return view1;
            }

            @Override
            public boolean isChildSelectable(int i, int i2) {
                return true;
            }
        };


        setListAdapter(adapter);

//        绑定孩子点击事件
        this.getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long l) {
                Toast.makeText(MainActivity.this, "你点击是"+children[i][i2], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}