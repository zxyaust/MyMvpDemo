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
    /**
     * 只管取,取出的结果何不合格也由业务层判断去,如果是异步的也要负责通知p层,所以他的职责就是取和通知
     *
     * @return
     */
    @Override
    public String getData() {
        return SharePrefUtils.getString("aaa", "");
    }

    /**
     * 只管存
     *
     * @param data
     */
    @Override
    public void setData(String data) {
        SharePrefUtils.putString("aaa", data);
    }
}
