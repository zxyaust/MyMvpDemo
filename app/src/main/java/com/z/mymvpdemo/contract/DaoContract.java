package com.z.mymvpdemo.contract;

/**
 * Created by max on 2016/10/28.
 */
public interface DaoContract {
    interface Model {
        String getData();
        void setData(String data);
    }
    interface View {
    }
    interface Presenter {
        String getData();
        void setData(String data);
    }
}