package com.example.tdq.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        registerForContextMenu(textView);//注册上下文菜单
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        SubMenu fontMenu = menu.addSubMenu("字体选择");
        fontMenu.setHeaderIcon(R.drawable.ic_launcher_foreground);
        fontMenu.setIcon(R.drawable.ic_launcher_background);
        fontMenu.setHeaderTitle("字体选择");
        fontMenu.add(0,0x001,0,"10号字体");
        fontMenu.add(0,0x002,0,"11号字体");
        fontMenu.add(0,0x003,0,"12号字体");
        fontMenu.add(0,0x004,0,"13号字体");

        menu.add(0,0x005,0,"普通菜单项");

        SubMenu colorMenu = menu.addSubMenu("颜色选择");
        colorMenu.setHeaderIcon(R.drawable.ic_launcher_foreground);
        colorMenu.setIcon(R.drawable.ic_launcher_background);
        colorMenu.setHeaderTitle("颜色选择");
        colorMenu.add(0,0x006,0,"红");
        colorMenu.add(0,0x007,0,"黄");
        colorMenu.add(0,0x008,0,"绿");
        colorMenu.add(0,0x009,0,"白");

        SubMenu startActivityMenu = menu.addSubMenu("启动另一个界面");
        startActivityMenu.setHeaderTitle("启动界面");
        MenuItem startMenuItem = startActivityMenu.add("启动second界面");
        startMenuItem.setIntent(new Intent(this,SecondActivity.class));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case 0x001:
                textView.setTextSize(10*2);
            break;

            case 0x002:
                textView.setTextSize(11*2);
                break;
            case 0x003:
                textView.setTextSize(12*2);
                break;
            case 0x004:
                textView.setTextSize(13*2);
                break;

            case 0x005:
                Toast.makeText(this,"这是一个普通菜单项",Toast.LENGTH_SHORT).show();
                break;

            case 0x006:
                textView.setTextColor(Color.RED);
                break;
            case 0x007:
                textView.setTextColor(Color.YELLOW);
                break;
            case 0x008:
                textView.setTextColor(Color.GREEN);
                break;
            case 0x009:
                textView.setTextColor(Color.WHITE);
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View source, ContextMenu.ContextMenuInfo info){
        contextMenu.add(0,0x10,0,"红色");
        contextMenu.add(0,0x11,0,"黄色");
        contextMenu.add(0,0x12,0,"蓝色");
        contextMenu.setHeaderTitle("选择背景色");

    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case 0x10:
                textView.setBackgroundColor(Color.RED);
                break;
            case 0x11:
                textView.setBackgroundColor(Color.YELLOW);
                break;
            case 0x12:
                textView.setBackgroundColor(Color.BLUE);
                break;
            default:
                return super.onContextItemSelected(menuItem);
        }
        return true;
    }
}
