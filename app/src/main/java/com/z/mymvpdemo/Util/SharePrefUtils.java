package com.z.mymvpdemo.Util;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * sharedpreference工具类
 */
public class SharePrefUtils {
    public static SharedPreferences sp;
    public static Context mContext = App.mContext;

    public static SharedPreferences getSharedPre() {
        if (sp == null) {
            sp = mContext.getSharedPreferences("config",
                    Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences sp = getSharedPre();
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(String key,
                                     boolean defValue) {
        SharedPreferences sp = getSharedPre();
        return sp.getBoolean(key, defValue);
    }

    public static void putString(String key, String value) {
        SharedPreferences sp = getSharedPre();
        sp.edit().putString(key, value).commit();
    }

    public static String getString(String key,
                                   String defValue) {
        SharedPreferences sp = getSharedPre();
        return sp.getString(key, defValue);
    }

    public static void putInt(String key, int value) {
        SharedPreferences sp = getSharedPre();
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(String key, int defValue) {
        SharedPreferences sp = getSharedPre();
        return sp.getInt(key, defValue);
    }

    public static void removeString(String key) {
        getSharedPre().edit().remove(key).commit();
    }
}
