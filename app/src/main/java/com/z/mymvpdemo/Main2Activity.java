package com.z.mymvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.z.mymvpdemo.view.DataActivity;
import com.z.mymvpdemo.view.NetActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void net(View view) {
        startActivity(new Intent(this, NetActivity.class));
    }

    public void dao(View view) {
        startActivity(new Intent(this, DataActivity.class));
    }
}
