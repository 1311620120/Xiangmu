package com.example.xiangmu.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.xiangmu.R;
import com.example.xiangmu.json.RxxpBean;
import com.example.xiangmu.presenter.RxxpPresenter;
import com.example.xiangmu.view.adapter.HomeRxxpAdapter;
import com.example.xiangmu.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RxxpActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.Xrecycler_Rxxp)
    RecyclerView XrecyclerRxxp;
    private RxxpPresenter rxxpPresenter;

    private String labelId;
    int page=1;
    int count=10;
    private GridLayoutManager gridLayoutManager;
    private HomeRxxpAdapter homeRxxpAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxxp);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        initData();

    }

    private void initData() {

        rxxpPresenter = new RxxpPresenter(this);
        rxxpPresenter.ShowData(labelId,page,count);
        rxxpPresenter.setView(this);

        gridLayoutManager = new GridLayoutManager(this, 2);
        XrecyclerRxxp.setLayoutManager(gridLayoutManager);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent(String id) {
        labelId = id;
        Toast.makeText(RxxpActivity.this, id + "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(Object o) {
        RxxpBean rxxpBean =(RxxpBean)o;
        Log.e("sss",""+rxxpBean.getResult().size());


        homeRxxpAdapter = new HomeRxxpAdapter(RxxpActivity.this,rxxpBean);
        XrecyclerRxxp.setAdapter(homeRxxpAdapter);
    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
