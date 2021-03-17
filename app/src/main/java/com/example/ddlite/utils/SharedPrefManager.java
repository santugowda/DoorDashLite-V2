package com.example.ddlite.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class SharedPrefManager {

    protected  Context mContext;
    protected String mPrefName;

    protected SharedPrefManager(Context context, String prefName) {
        mContext = context.getApplicationContext();
        mPrefName = prefName;
    }

    protected void setBooleanPolicy(String key, boolean value) {
        SharedPreferences sp = getSharedPref();
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    protected boolean getBooleanPolicy(String key, boolean defaultValue) {
        boolean value = defaultValue;
        if(!TextUtils.isEmpty(key)) {
            SharedPreferences sp = getSharedPref();
            value = sp.getBoolean(key, defaultValue);
        }
        return value;
    }

    private SharedPreferences getSharedPref() {
        return mContext.getSharedPreferences(mPrefName, Context.MODE_PRIVATE);
    }

}
