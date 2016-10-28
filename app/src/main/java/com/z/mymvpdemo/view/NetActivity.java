package com.z.mymvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.z.mymvpdemo.R;
import com.z.mymvpdemo.bean.UserBean;
import com.z.mymvpdemo.contract.UserContract;
import com.z.mymvpdemo.presenter.UserPresenter;

/**
 * 模拟网络请求
 */
public class NetActivity extends AppCompatActivity implements UserContract.IUserView, View.OnClickListener {

    private EditText mTvUnameEditText;
    private EditText mPwdEditText;
    private TextView mLoginButton;
    private UserPresenter userPresenter = new UserPresenter(this);
    private TextView mTvTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvUnameEditText = (EditText) findViewById(R.id.tv_uname);
        mPwdEditText = (EditText) findViewById(R.id.pwd);
        mLoginButton = (TextView) findViewById(R.id.bt_login);
        mTvTextView = (TextView) findViewById(R.id.tv);
        mLoginButton.setOnClickListener(this);

    }

    @Override
    public void LoginSuceess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mLoginButton.setText("成功");
                mTvTextView.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void LoginFaild() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mLoginButton.setText("失败");
                mTvTextView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void LoginStart() {

        mLoginButton.setText("正在登录");
        mTvTextView.setVisibility(View.VISIBLE);

    }

    @Override
    public void UserInfoError() {
        mLoginButton.setText("错误");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                UserBean userBean = new UserBean(mTvUnameEditText.getText().toString(), mPwdEditText.getText().toString());
                userPresenter.login(userBean);
                break;
        }

    }
}
