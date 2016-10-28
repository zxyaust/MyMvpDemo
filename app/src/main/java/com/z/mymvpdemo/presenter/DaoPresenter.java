package com.z.mymvpdemo.presenter;


import android.text.TextUtils;

import com.z.mymvpdemo.contract.DaoContract;
import com.z.mymvpdemo.model.DaoModel;

public class DaoPresenter implements DaoContract.Presenter {
    public DaoPresenter(DaoContract.View view) {
        this.daoView = view;
        daoModel = new DaoModel();
    }

    /**
     * 持有v对象,用于发通知
     */
    private DaoContract.View daoView;
    /**
     * 持有m对象,用于向下发命令
     */
    private DaoContract.Model daoModel;

    /**
     * 只是业务逻辑,和通知v或者m层,不管任何界面的事,也不管底层数据如何操作
     *
     * @return
     */
    @Override
    public String getData() {
        String data = daoModel.getData();
        if (TextUtils.isEmpty(data)) {
            daoView.onError();
            return "";
        } else {
            daoView.onGetDataSuceess();
            return data;
        }
    }

    /**
     * 发给m层命令
     * @param data
     */
    @Override
    public void setData(String data) {
        daoModel.setData(data);
    }
}