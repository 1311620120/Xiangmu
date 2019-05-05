package com.example.xiangmu.view.frangment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.R;
import com.example.xiangmu.json.QuanJson;
import com.example.xiangmu.presenter.QuanZiPresenter;
import com.example.xiangmu.view.adapter.QuanAdapter;
import com.example.xiangmu.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;


public class EvaluateFragment extends Fragment implements IMainView {

    private View view;
    private XRecyclerView quan_recycler;
    private LinearLayoutManager linearLayoutManager;
    private QuanZiPresenter quanZiPresenter;
   int page=1;
   int count=10;
    private QuanAdapter quanAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.evaluatefragment, container, false);
        initData();
        initView();
        return view;
    }
    private void initView() {
        quan_recycler = view.findViewById(R.id.Quan_recycler);

        quan_recycler.setPullRefreshEnabled(true);
        quan_recycler.setLoadingMoreEnabled(true);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        quan_recycler.setLayoutManager(linearLayoutManager);
        quan_recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                quan_recycler.refreshComplete();
                quanZiPresenter.QuanData(page,count);
                quanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                quan_recycler.loadMoreComplete();
                quanZiPresenter.QuanData(page,count );
                quanAdapter.notifyDataSetChanged();
            }
        });
    }
    private void initData() {
        quanZiPresenter = new QuanZiPresenter(this);
        quanZiPresenter.QuanData(page,count );
        quanZiPresenter.setView(this);



    }



    @Override
    public void onSuccess(Object o) {
        QuanJson quanJson =(QuanJson)o;
        quanAdapter = new QuanAdapter(getActivity(),quanJson);
        quan_recycler.setAdapter(quanAdapter);
    }

    @Override
    public void onFail(String str) {

    }
}
