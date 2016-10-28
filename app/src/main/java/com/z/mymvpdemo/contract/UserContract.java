package com.z.mymvpdemo.contract;

import com.z.mymvpdemo.bean.UserBean;

/**
 * Created by max on 2016/10/28.
 */
public interface UserContract {
     interface IUserModel {
        void login(UserBean userBean, OnLoginListener listener);
    }
    interface OnLoginListener {
        void onSucess();
        void onFailed();
    }
     interface IUserView {
        void LoginSuceess();

        void LoginFaild();

        void LoginStart();

        void UserInfoError();
    }

     interface IUserPresenter {
        void login(UserBean bean);
        boolean check(UserBean bean);
    }
}
