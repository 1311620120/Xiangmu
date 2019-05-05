package com.example.xiangmu.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.xiangmu.R;
import com.example.xiangmu.json.MlssBean;
import com.example.xiangmu.json.RxxpBean;
import com.example.xiangmu.presenter.MlssPresenter;
import com.example.xiangmu.view.adapter.HomeMlssAdapter;
import com.example.xiangmu.view.adapter.HomeRxxpAdapter;
import com.example.xiangmu.view.interfaces.IMainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MlssActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.Rceycler_Mlss)
    RecyclerView RceyclerMlss;
    String labelId;
    int page=1;
    int count=10;
    private GridLayoutManager gridLayoutManager;
    private MlssPresenter mlssPresenter;
    private HomeMlssAdapter homeMlssAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlss);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initData();
    }

    private void initData() {

        mlssPresenter = new MlssPresenter(this);
        mlssPresenter.ShowData(labelId,page,count);
        mlssPresenter.setView(this);

        gridLayoutManager = new GridLayoutManager(this, 2);
        RceyclerMlss.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onSuccess(Object o) {
        MlssBean mlssBean =(MlssBean) o;
        homeMlssAdapter = new HomeMlssAdapter(MlssActivity.this, mlssBean);
        RceyclerMlss.setAdapter(homeMlssAdapter);
    }

    @Override
    public void onFail(String str) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public  void  getEvent(String id){
        labelId=id;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
