package com.codingburg.sql;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class SharedPrefarenceManager {
    private static SharedPrefarenceManager instance;
    private static Context ctx;
    private static final String SHARED_PFER_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL= "useremail";
    private static final String KEY_USER_ID = "userid";


    private SharedPrefarenceManager(Context context) {
        ctx = context;

    }

    public static synchronized SharedPrefarenceManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefarenceManager(context);
        }
        return instance;
    }
    public boolean userLogin(int id, String name, String email){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PFER_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, name);
        editor.apply();
        return true;
    }
    public  boolean isLoggedin(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PFER_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null ) != null){
            return true;
        }
        return false;
    }

    public boolean logOut(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PFER_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;

    }
    public  String getName(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PFER_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USERNAME, null);
    }
    public  String getEmail(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PFER_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_EMAIL, null);
    }

}