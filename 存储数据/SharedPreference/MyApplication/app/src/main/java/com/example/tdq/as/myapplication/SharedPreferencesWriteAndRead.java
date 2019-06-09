package com.example.tdq.as.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;

/**
 * Created by TDQ on 2019/5/31.
 */

public class SharedPreferencesWriteAndRead {
    private final static String USER = "user";
    private final static String USERNAME = "username";
    private final static String USERPASSWORD = "userpassword";
    private final static String CHECKBOXSTATE = "checkboxstate";
    private static SharedPreferences sharedPreferences ;
    private static SharedPreferences.Editor editor;

    public static String ReadUsername(Context context){
        sharedPreferences = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(USERNAME,"");
    }
    public static void WriteUsername(Context context,String username){
        sharedPreferences = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(USERNAME,username);
        editor.commit();
    }
    public static String ReadPassword(Context context){
        sharedPreferences = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(USERPASSWORD,"");
    }
    public static void WriteUserPassword(Context context,String userpassword){
        sharedPreferences = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(USERPASSWORD,userpassword);
        editor.commit();
    }

    public static Boolean ReadCheckBoxState(Context context){
        sharedPreferences = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(CHECKBOXSTATE,false);
    }
    public static void WriteCheckBoxState(Context context,Boolean checkBoxState){
        sharedPreferences = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(CHECKBOXSTATE,checkBoxState);
        editor.commit();
    }

}
