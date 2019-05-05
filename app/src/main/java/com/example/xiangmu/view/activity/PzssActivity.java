package com.example.xiangmu.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xiangmu.R;
import com.example.xiangmu.json.MlssBean;
import com.example.xiangmu.json.PzshBean;
import com.example.xiangmu.presenter.PzshPresenter;
import com.example.xiangmu.view.adapter.HomeMlssAdapter;
import com.example.xiangmu.view.adapter.HomePzshAdapter;
import com.example.xiangmu.view.interfaces.IMainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PzssActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.Recycler_Pzsh)
    RecyclerView RecyclerPzsh;
    private PzshPresenter pzshPresenter;
    private GridLayoutManager gridLayoutManager;
    private HomePzshAdapter homePzshAdapter;
    private  String labelId;
    private  int page=1,count=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pzss);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        init();
    }

    private void init() {

        pzshPresenter = new PzshPresenter(this);
        pzshPresenter.ShowData(labelId,page,count);
        pzshPresenter.setView(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        RecyclerPzsh.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onSuccess(Object o) {
        PzshBean pzshBean =(PzshBean) o;
        homePzshAdapter = new HomePzshAdapter(PzssActivity.this, pzshBean);
        RecyclerPzsh.setAdapter(homePzshAdapter);
    }

    @Override
    public void onFail(String str) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
     public  void getEventBus(String id){
        labelId=id;
     }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
