package com.example.xiangmu.applicontion;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application
{

    private static SharedPreferences sp;

    public static SharedPreferences getSp() {
        return sp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sp = this.getSharedPreferences("jun", MODE_PRIVATE);
    }
}
