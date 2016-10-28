package com.z.mymvpdemo.presenter;


import com.z.mymvpdemo.bean.UserBean;
import com.z.mymvpdemo.contract.UserContract;
import com.z.mymvpdemo.model.UserModel;

public class UserPresenter implements UserContract.IUserPresenter {
    public UserPresenter(UserContract.IUserView userView) {
        this.userView = userView;
        userModel = new UserModel();
    }

    private UserContract.IUserView userView;
    private UserContract.IUserModel userModel;

    @Override
    public boolean check(UserBean bean) {
        if (bean.getPsd().isEmpty() || bean.getUName().isEmpty()) {
            userView.UserInfoError();
            return false;
        }
        return true;
    }

    @Override
    public void login(final UserBean userBean) {
        if (!check(userBean))
            return;
        userView.LoginStart();
        userModel.login(userBean, new UserContract.OnLoginListener() {
            @Override
            public void onSucess() {
                userView.LoginSuceess();
            }

            @Override
            public void onFailed() {
                userView.LoginFaild();
            }
        });

    }


}