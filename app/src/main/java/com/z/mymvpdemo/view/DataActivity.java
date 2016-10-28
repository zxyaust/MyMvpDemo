package com.z.mymvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.z.mymvpdemo.R;
import com.z.mymvpdemo.Util.ToastUtils;
import com.z.mymvpdemo.contract.DaoContract;
import com.z.mymvpdemo.presenter.DaoPresenter;

/**
 * 模拟数据库操作
 */
public class DataActivity extends AppCompatActivity implements DaoContract.View {

    private EditText mTvEditText;
    /**
     * 要持有p对象,用于向下发送命令
     */
    private DaoPresenter daoPresenter = new DaoPresenter(this);
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        mTvEditText = (EditText) findViewById(R.id.tv);

    }

    /**
     * 只是发出这个取的消息,取到了没取到交给p层判断,不做任何业务逻辑
     * @param view
     */
    public void get(View view) {
        data = daoPresenter.getData();
    }

    /**
     * 发出存数据的命令,并更新界面,v层只管发命令,更界面,其他的绝对不干
     * @param view
     */
    public void set(View view) {
        data = mTvEditText.getText().toString();
        daoPresenter.setData(data);
        mTvEditText.setText("");
        ToastUtils.show("保存了:" + data);
    }

    /**
     * 取失败了
     */
    @Override
    public void onError() {
        ToastUtils.show("数据库操作错误");
    }

    /**
     * 取成功了
     */
    @Override
    public void onGetDataSuceess() {
        mTvEditText.setText(data);
        ToastUtils.show("取出了:" + data);
    }
}
