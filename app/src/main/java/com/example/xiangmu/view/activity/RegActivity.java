package com.example.xiangmu.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiangmu.R;
import com.example.xiangmu.json.RegBean;
import com.example.xiangmu.presenter.RegPersenter;
import com.example.xiangmu.view.interfaces.IMainView;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity implements IMainView,View.OnClickListener {
    private EditText name;
    private EditText pwd;
    private RegPersenter regPersenter;
    private Intent intent;
    private HashMap<String, String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        initData();
    }

    private void initView() {
        name = findViewById(R.id.reg_edit_phone);
        pwd = findViewById(R.id.reg_edit_pass);
        findViewById(R.id.reg_button_login).setOnClickListener(this);
        findViewById(R.id.reg_text_login).setOnClickListener(this);
    }

    private void initData() {
        regPersenter = new RegPersenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg_button_login:
                map = new HashMap<>();

                String uName = name.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                map.put("phone",uName);
                map.put("pwd",pass);
                regPersenter.getRegData(map);
                regPersenter.setView(this);
                break;
            case R.id.reg_text_login:
                intents();
                break;

        }

    }

    @Override
    public void onSuccess(Object o) {
        RegBean regBean =(RegBean)o;
        Log.e("+++++",regBean+"");
        Log.e("yiiyiy",regBean.getStatus()+"");
        if (regBean.getStatus().equals("0000")){
            Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            intents();
        }
    }



    @Override
    public void onFail(String str) {

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        regPersenter.detachView();
    }
    private void intents() {
        intent = new Intent(RegActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
