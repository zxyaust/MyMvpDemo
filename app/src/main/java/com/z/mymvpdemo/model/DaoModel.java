package com.z.mymvpdemo.model;

import com.z.mymvpdemo.Util.SharePrefUtils;
import com.z.mymvpdemo.contract.DaoContract;

/**
 * Created by Miller Zhang  on 2016/10/28.
 * desc:
 * github:https://github.com/zxyaust
 * CSDN:http://blog.csdn.net/qq_31340657
 * Whatever happens tomorrow,we've had today.
 */
public class DaoModel implements DaoContract.Model {
    @Override
    public String getData() {
        return SharePrefUtils.getString("aaa", "");
    }

    @Override
    public void setData(String data) {
        SharePrefUtils.putString("aaa", data);
    }
}
