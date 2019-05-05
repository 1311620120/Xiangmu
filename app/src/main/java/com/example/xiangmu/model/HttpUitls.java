package com.example.xiangmu.model;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


import com.example.xiangmu.applicontion.MyApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/23 14:48:39
 * @Description:
 */
public class HttpUitls<T>{
    public static String nei = "http://172.17.8.100/";
    public static String wai = "http://mobile.bwstudent.com";
    public static Api api;
    private  OkHttpClient okHttpClient;
    private  static  class  HttpUtilsInstansce{
        private  static  HttpUitls httpUitls=new HttpUitls();
    }
    public  static  HttpUitls getInstance(){
        return  HttpUtilsInstansce.httpUitls;
    }

    private HttpUitls(){
          okHttpClient = new OkHttpClient.Builder()
                 .addNetworkInterceptor(new LogginIntecepter())
                 .readTimeout(5, TimeUnit.SECONDS)
                 .writeTimeout(5, TimeUnit.SECONDS)
                  .connectTimeout(5,TimeUnit.SECONDS)
                 .build();
         Retrofit retrofit = new Retrofit.Builder()
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl(nei)
                 .client(okHttpClient)
                 .build();
        api = retrofit.create(Api.class);
     }


     private  class  LogginIntecepter implements Interceptor{
         @Override
         public Response intercept(Chain chain) throws IOException {
             SharedPreferences sp = MyApplication.getSp();
         /*    String sessionId = result.getSessionId();
             int userId = result.getUserId();*/
             int userId = sp.getInt("userId", 0);
             String sessionId = sp.getString("sessionId",null);
             Log.e("nhj", "添加用户id="+userId+"添加sessionID="+sessionId);
             Request request = chain.request();
             Request request1 = request.newBuilder()
                     .addHeader("userId", String.valueOf(userId))
                     .addHeader("sessionId", sessionId)
                     .build();
             Response proceed = chain.proceed(request1);
             return proceed;
         }
     }

}
