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
    private DaoPresenter daoPresenter = new DaoPresenter(this);
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        mTvEditText = (EditText) findViewById(R.id.tv);

    }

    public void get(View view) {
        data = daoPresenter.getData();
        mTvEditText.setText(data);
        ToastUtils.show("取出了:" + data);
    }

    public void set(View view) {
        data = mTvEditText.getText().toString();
        daoPresenter.setData(data);
        mTvEditText.setText("");
        ToastUtils.show("保存了:" + data);
    }
}
