package com.example.tdq.as.sqltest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInsert,editTextDelete,editTextSelect,editTextShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySqlOpenHelper openHelper = new MySqlOpenHelper(this,1);
        openHelper.getWritableDatabase();
        editTextInsert = findViewById(R.id.et_insert);
        editTextDelete = findViewById(R.id.et_delete);
        editTextSelect = findViewById(R.id.et_select);
        editTextShow = findViewById(R.id.et_show);
    }

    public void onClick(View view) {
        String name = "";
        switch (view.getId()){
            case R.id.bt_insert:
                 name = editTextInsert.getText().toString();
                inert(name);
                break;
            case R.id.bt_delete:
                name = editTextDelete.getText().toString();
                delete(name);
                break;
            case R.id.bt_select:
                name = editTextSelect.getText().toString();
                select(name);
                break;
            default:break;
        }
    }

    private void select(String name) {
        MySqlOpenHelper openHelper = new MySqlOpenHelper(this,1);
        SQLiteDatabase sqLiteDatabase = openHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from studenttable where studentname=?",new String[]{name});
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String nam = cursor.getString(cursor.getColumnIndex("studentname"));
            String information = id + nam;
            editTextShow.setText(information);
        }
    }

    private void delete(String name) {
        //方法1
        MySqlOpenHelper openHelper = new MySqlOpenHelper(this,1);
        SQLiteDatabase sqLiteDatabase = openHelper.getReadableDatabase();
        long n = sqLiteDatabase.delete("studenttable","studentname=?",new String[]{name});
        if (n!=-1){
            Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
        }
        //方法2
        //sqLiteDatabase.execSQL("delete from studenttable where studentname = name");
    }

    public void inert(String name){
        //方法1
        MySqlOpenHelper openHelper = new MySqlOpenHelper(this,1);
        SQLiteDatabase sqLiteDatabase = openHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentname",name);
        long n = sqLiteDatabase.insert("studenttable",null,contentValues);
        Log.d("deqin",n+"");
        if(n!=-1){
            Toast.makeText(this,"插入成功",Toast.LENGTH_SHORT).show();
        }

        //方法2
        //sqLiteDatabase.execSQL("insert into studenttable(studentname) values(name)");
    }

}
