package com.z.mymvpdemo.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jeff on 2016/6/1.
 */
public class ToastUtils {


    private static Toast toast;
    private static Context con = App.mContext;

    public static void show(CharSequence text) {
        if (toast == null) {
            toast = Toast.makeText(con, text, Toast.LENGTH_SHORT);
        }

        toast.setText(text);
        toast.show();
    }


}
