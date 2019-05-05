package com.example.xiangmu.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiangmu.R;
import com.example.xiangmu.applicontion.MyApplication;
import com.example.xiangmu.json.LoginBean;
import com.example.xiangmu.presenter.LoginPresenter;
import com.example.xiangmu.view.interfaces.IMainView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements IMainView ,View.OnClickListener {
    private EditText Edit_name;
    private EditText Edit_pwd;
    private LoginPresenter loginPresenter;
    private String nname;
    private String ppwd;
    private CheckBox check;

    private HashMap<String, String> map;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }
    private void initView() {
        Edit_name = findViewById(R.id.login_edit_phone);
        Edit_pwd = findViewById(R.id.login_edit_pass);
        check = findViewById(R.id.login_box_remember);

    }
    private void initData() {
        loginPresenter = new LoginPresenter(this);
        findViewById(R.id.login_button_login).setOnClickListener(this);
        findViewById(R.id.login_text_reg).setOnClickListener(this);

      /*
      *  获取 SP
      *
      * */
        sp = MyApplication.getSp();
     //   this.sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean jizhu = this.sp.getBoolean("记住", false);
        if (jizhu){
            String user = this.sp.getString("user", "");
            String pass = this.sp.getString("pass", "");
            Edit_name.setText(user);
            Edit_pwd.setText(pass);
            check.setChecked(true);
        }
    }



    @Override
    public void onSuccess(Object o) {
        LoginBean loginBean = (LoginBean) o;
        String sessionId1 = loginBean.getResult().getSessionId();
        int userId1 = loginBean.getResult().getUserId();
        Log.e("sessionId1",""+sessionId1);
        Log.e("sessuserId1",""+userId1);
        if (nname.equals("")||ppwd.equals("")){
            Toast.makeText(LoginActivity.this, "账号或密码为空！", Toast.LENGTH_SHORT).show();
        }else {

            if (loginBean.getStatus().equals("0000")) {
                LoginBean.ResultBean result = loginBean.getResult();
                String nickName = result.getNickName();
                String sessionId = result.getSessionId();
                int userId = result.getUserId();
                String phone = result.getPhone();
                String headPic = result.getHeadPic();
                //TODO: 头部入参
                Log.e("nhj", "onSuccess: 用户id="+userId+"sessionId="+sessionId);

                //存值
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("记住",check.isChecked());
                edit.putString("user",nname);
                edit.putString("pass",ppwd);
                edit.putString("nickName",nickName);
                edit.putString("sessionId",sessionId);
                edit.putString("headPic",headPic);
                edit.putString("phone",phone);
                edit.putInt("userId",userId);
                edit.commit();
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(LoginActivity.this, "账号或密码输入有误！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFail(String str) {

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        loginPresenter.detachView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button_login:
                map = new HashMap<>();

                nname = Edit_name.getText().toString().trim();
                ppwd = Edit_pwd.getText().toString().trim();
                map.put("phone",nname);
                map.put("pwd",ppwd);
              loginPresenter.getLoginData(map);
                loginPresenter.setView(this);
                break;
            case R.id.login_text_reg:
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
        }
    }
}
