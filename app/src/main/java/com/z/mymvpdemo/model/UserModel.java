package com.z.mymvpdemo.model;

import com.z.mymvpdemo.bean.UserBean;
import com.z.mymvpdemo.contract.UserContract;

/**
 * Created by max on 2016/10/28.
 */
public class UserModel implements UserContract.IUserModel {
    @Override
    public void login(final UserBean userBean, final UserContract.OnLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if ("111".equals(userBean.getUName()) && "111".equals(userBean.getPsd())) {
                        listener.onSucess();
                    } else {
                        listener.onFailed();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
