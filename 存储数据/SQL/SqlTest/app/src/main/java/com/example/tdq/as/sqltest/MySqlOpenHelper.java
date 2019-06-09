package com.example.tdq.as.sqltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by TDQ on 2019/6/2.
 */

public class MySqlOpenHelper extends SQLiteOpenHelper {
    public MySqlOpenHelper(Context context,int version) {
        super(context, "database.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "create table studenttable(_id integer primary key autoincrement,studentname text)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("deqin","onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
