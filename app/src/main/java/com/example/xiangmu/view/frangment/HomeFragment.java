package com.example.xiangmu.view.frangment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xiangmu.R;
import com.example.xiangmu.json.BannerJson;
import com.example.xiangmu.json.ShowJson;
import com.example.xiangmu.json.SouBean;
import com.example.xiangmu.presenter.BannerPresenter;
import com.example.xiangmu.presenter.HomePresenter;
import com.example.xiangmu.presenter.SouPresenter;
import com.example.xiangmu.view.activity.MlssActivity;
import com.example.xiangmu.view.activity.PzssActivity;
import com.example.xiangmu.view.activity.RxxpActivity;
import com.example.xiangmu.view.adapter.SouAdapter;
import com.example.xiangmu.view.adapter.MlssAdapter;
import com.example.xiangmu.view.adapter.PzshAdapter;
import com.example.xiangmu.view.adapter.RxxpAdapter;
import com.example.xiangmu.view.interfaces.IMainView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeFragment extends Fragment implements IMainView {

    @BindView(R.id.check_Rxxp)
    TextView checkRxxp;
    @BindView(R.id.check_Mlss)
    TextView checkMlss;
    @BindView(R.id.check_Pzsh)
    TextView checkPzsh;
    Unbinder unbinder;
    private View view;
    private HomePresenter homePresenter;
    private RecyclerView recycler_rxxp;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView recycler_mlss;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recycler_pzsh;
    private GridLayoutManager gridLayoutManager1;
    private BannerPresenter bannerPresenter;
    private XBanner home_xBanner;
    private ShowJson.ResultBean bean;
    private  int page=1;
    private  int count=10;
    private String keyword;
    private RecyclerView home_sou;
    private SouAdapter souAdapter;
    private LinearLayout oneView;
    private LinearLayout twoView;
    private SouPresenter souPresenter;
    private EditText incloud_text;
    private ImageView incloud_button;
    private ImageView incloud_return;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homefragment, container, false);
        initView();
        initData();
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    private void initView() {

        /*
             热销产品
         */
        recycler_rxxp = view.findViewById(R.id.recycler_rxxp);
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recycler_rxxp.setLayoutManager(gridLayoutManager);
         /*
             魔力时尚
         */
        recycler_mlss = view.findViewById(R.id.recycler_mlss);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recycler_mlss.setLayoutManager(linearLayoutManager);
        /*
           品质生活
         */
        recycler_pzsh = view.findViewById(R.id.recycler_pzsh);
        gridLayoutManager1 = new GridLayoutManager(getActivity(), 2);
        recycler_pzsh.setLayoutManager(gridLayoutManager1);

        home_xBanner = view.findViewById(R.id.Home_XBanner);

        home_sou = view.findViewById(R.id.Home_Sou);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        home_sou.setLayoutManager(gridLayoutManager);

        oneView = view.findViewById(R.id.One);
        twoView = view.findViewById(R.id.Two);
        incloud_text = view.findViewById(R.id.incloud_text);
        incloud_button = view.findViewById(R.id.incloud_button);
        incloud_return = view.findViewById(R.id.incloud_return);
    }

    private void initData() {
          /*
            首页初始化P层
         */
        homePresenter = new HomePresenter(this);
        homePresenter.HomeData();
        homePresenter.setView(this);
         /*
            轮播图初始化P层
         */
        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.BannerData();
        bannerPresenter.setView(this);

        souPresenter = new SouPresenter(this);
        souPresenter.setView(this);

        incloud_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(incloud_text.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "请输入你要搜索的商品", Toast.LENGTH_SHORT).show();
                }else {
                    twoView.setVisibility(View.VISIBLE);
                    oneView.setVisibility(View.GONE);

                    keyword = incloud_text.getText().toString();
                    Log.e("keyword",keyword);
                    souPresenter.ShuData(keyword,page,count);
                }

            }
        });
        incloud_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoView.setVisibility(View.GONE);
                oneView.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ShowJson) {
            ShowJson showJson = (ShowJson) o;
            bean = showJson.getResult();
        /*
             热销产品
         */
            RxxpAdapter rxxpAdapter = new RxxpAdapter(getActivity(), bean);
            recycler_rxxp.setAdapter(rxxpAdapter);
         /*
             品质生活
         */
            PzshAdapter pzshAdapter = new PzshAdapter(getActivity(), bean);
            recycler_pzsh.setAdapter(pzshAdapter);
        /*
             魔力时尚
         */
            MlssAdapter mlssAdapter = new MlssAdapter(getActivity(), bean);
            recycler_mlss.setAdapter(mlssAdapter);
        }
        if (o instanceof BannerJson) {
            BannerJson bannerJson = (BannerJson) o;
            final List<BannerJson.ResultBean> result = bannerJson.getResult();
            final ArrayList<String> objects = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                objects.add(result.get(i).getImageUrl());
            }
            home_xBanner.setData(objects, null);
            home_xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(HomeFragment.this).load(objects.get(position)).into((ImageView) view);
                }
            });
            home_xBanner.setPageTransformer(Transformer.Cube);    //立体旋转
            // 设置XBanner页面切换的时间，即动画时长
            home_xBanner.setPageChangeDuration(1000);
        }
        if (o instanceof SouBean){
           SouBean souBean =(SouBean)o;
           Log.e("TAG",""+souBean.getResult().size());
            souAdapter = new SouAdapter(getActivity(),souBean);
            home_sou.setAdapter(souAdapter);

       }
    }

    @Override
    public void onFail(String str) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

   @OnClick({R.id.check_Rxxp, R.id.check_Mlss, R.id.check_Pzsh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.check_Rxxp:
                String rid = bean.getRxxp().getId();
                EventBus.getDefault().postSticky(rid);
                startActivity(new Intent(getActivity(),MlssActivity.class));
                break;
            case R.id.check_Mlss:
                EventBus.getDefault().postSticky(bean.getMlss().getId());
                startActivity(new Intent(getActivity(),RxxpActivity.class));
                break;
            case R.id.check_Pzsh:
                EventBus.getDefault().postSticky(bean.getPzsh().getId());
                startActivity(new Intent(getActivity(),PzssActivity.class));
                break;
        }
    }
}
