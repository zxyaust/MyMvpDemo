package com.z.mymvpdemo.model;

import com.z.mymvpdemo.bean.UserBean;
import com.z.mymvpdemo.contract.UserContract;

/**
 * Created by max on 2016/10/28.
 * 不持有v和p层对象,但是用到了listener对象,用于向上发送通知,这是异步操作时才需要的
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
