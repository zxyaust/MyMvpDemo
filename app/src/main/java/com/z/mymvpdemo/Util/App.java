package com.z.mymvpdemo.Util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Miller Zhang  on 2016/10/28.
 * desc:
 * github:https://github.com/zxyaust
 * CSDN:http://blog.csdn.net/qq_31340657
 * Whatever happens tomorrow,we've had today.
 */
public class App extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
