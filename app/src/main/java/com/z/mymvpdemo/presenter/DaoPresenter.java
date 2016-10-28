package com.z.mymvpdemo.presenter;


import com.z.mymvpdemo.contract.DaoContract;
import com.z.mymvpdemo.model.DaoModel;

public class DaoPresenter implements DaoContract.Presenter {
    public DaoPresenter(DaoContract.View view) {
        this.daoView = view;
        daoModel = new DaoModel();
    }

    private DaoContract.View daoView;
    private DaoContract.Model daoModel;

    @Override
    public String getData() {
        return daoModel.getData();
    }

    @Override
    public void setData(String data) {
        daoModel.setData(data);
    }
}