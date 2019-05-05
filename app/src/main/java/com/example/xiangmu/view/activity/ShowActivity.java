package com.example.xiangmu.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xiangmu.R;
import com.example.xiangmu.view.frangment.CarFragment;
import com.example.xiangmu.view.frangment.EvaluateFragment;
import com.example.xiangmu.view.frangment.HomeFragment;
import com.example.xiangmu.view.frangment.MyFragment;
import com.example.xiangmu.view.frangment.OrderFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ShowActivity extends AppCompatActivity {
    private BottomTabBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        bar = findViewById(R.id.bar);
        bar.init(getSupportFragmentManager())
                .setTabPadding(80,10,2)
                .setFontSize(0)
                .setImgSize(50,50)
                .addTabItem("首页",R.mipmap.tab_home_bottom_shouyes,R.mipmap.tab_home_bottom_shouye,HomeFragment.class)
                .addTabItem("发现",R.mipmap.tab_home_bottom_quanzis,R.mipmap.tab_home_bottom_quanzi,EvaluateFragment.class)
                .setImgSize(130,130)
                .setTabPadding(10,10,3)
                .addTabItem("购物车",R.mipmap.tab_home_bottom_gouwuche,R.mipmap.tab_home_bottom_gouwuche,CarFragment.class)
                .setTabPadding(80,10,2)
                .setImgSize(50,50)
                .addTabItem("详情",R.mipmap.tab_home_bottom_zhangdans,R.mipmap.tab_home_bottom_zhangdan,OrderFragment.class)
                .addTabItem("我的",R.mipmap.tab_home_bottom_wodes,R.mipmap.tab_home_bottom_wode,MyFragment.class)
                .setTabBarBackgroundResource(R.mipmap.bg_homepage_bottom);
    }
}
