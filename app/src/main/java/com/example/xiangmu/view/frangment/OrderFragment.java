package com.example.xiangmu.view.frangment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xiangmu.R;
import com.example.xiangmu.applicontion.MyApplication;
import com.example.xiangmu.json.AddCarBean;
import com.example.xiangmu.json.SelectBean;
import com.example.xiangmu.json.TongBean;
import com.example.xiangmu.presenter.AddCarPresenter;
import com.example.xiangmu.presenter.SecectPresenter;
import com.example.xiangmu.view.activity.PingActivity;
import com.example.xiangmu.view.adapter.PingAdapter;
import com.example.xiangmu.view.interfaces.IMainView;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends Fragment implements IMainView {

    private View view;
    private ImageView bill_image_appraise;
    private LinearLayout pingjia;
    private SharedPreferences sp;
    private String sessionId;
    private int userId;
    private String data;
    private SecectPresenter secectPresenter;
    private RecyclerView ordrecycler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.orderfragment, container, false);
        initView();
        initData();
        return view;
    }
    private void initView() {
        bill_image_appraise = view.findViewById(R.id.bill_image_appraise);
        pingjia = view.findViewById(R.id.pingjia);
        ordrecycler = view.findViewById(R.id.ordrecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        ordrecycler.setLayoutManager(linearLayoutManager);
    }
    private void initData() {
          bill_image_appraise.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   pingjia.setVisibility(View.VISIBLE);
              }
          });
        secectPresenter = new SecectPresenter();
        secectPresenter.SelectData(userId,sessionId);
        secectPresenter.setView(this);

    }

    @Override
    public void onResume() {
        super.onResume();

        sp = MyApplication.getSp();
       /* SharedPreferences.Editor edit = sp.edit();
        edit.putString("commodityId","");
        edit.commit();*/

        //登录成功后 获取userid和sessionid

        sessionId = sp.getString("sessionId", sessionId);
        userId = sp.getInt("userId", userId);
        String commodityid1 = sp.getString("commodityId", "");
        //Log.e("myshop", commodityid1);
        //拆分传过来的commodityId
        String[] split = commodityid1.split(",");
        //自己写一个bean类
        ArrayList<TongBean> arr = new ArrayList<>();
        //循环及添加
        for (int i = 1; i < split.length; i++) {
            TongBean tongBean = new TongBean();
            tongBean.setCommodityId(split[i]);
            tongBean.setCount(1);
            arr.add(tongBean);
        }
        Gson gson = new Gson();
        //转换成数组类型  这里  接口文档需要传一个数组类型
        data = gson.toJson(arr);

        Log.e("myshop", data + "");
        Log.e("myshop", sessionId + "");
        Log.e("myshop", userId + "");
        // textView.setText(sessionId);
        AddCarPresenter addCarPresenter = new AddCarPresenter();
        addCarPresenter.AddCatData(userId, sessionId, data);
        addCarPresenter.setView(this);
        //Log.e("my","同步成功");
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof SelectBean){
            final SelectBean selectBean =(SelectBean)o;
            final List<SelectBean.ResultBean> result = selectBean.getResult();

            PingAdapter pingAdapter = new PingAdapter(getActivity(),result);
            ordrecycler.setAdapter(pingAdapter);
        }
        if (o instanceof AddCarBean) {
            AddCarBean addCarBean = (AddCarBean) o;
            String message = addCarBean.getMessage();
            if (message.equals("同步成功")) {
                secectPresenter.SelectData(userId, sessionId);
            }
        }
    }

    @Override
    public void onFail(String str) {

    }
}
