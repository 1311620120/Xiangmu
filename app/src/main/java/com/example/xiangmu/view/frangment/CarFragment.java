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
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.xiangmu.R;
import com.example.xiangmu.applicontion.MyApplication;
import com.example.xiangmu.json.AddCarBean;
import com.example.xiangmu.json.SelectBean;
import com.example.xiangmu.json.TongBean;
import com.example.xiangmu.presenter.AddCarPresenter;
import com.example.xiangmu.presenter.SecectPresenter;
import com.example.xiangmu.view.adapter.ShopAdapter;
import com.example.xiangmu.view.interfaces.IMainView;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class CarFragment extends Fragment implements IMainView {


    @BindView(R.id.shop_view_bottom)
    View shopViewBottom;
    @BindView(R.id.shop_text_bottom)
    TextView shopTextBottom;

    CheckBox shopBoxAll;
    @BindView(R.id.shop_text_all)
    TextView shopTextAll;
    @BindView(R.id.shop_text_allpr)
    TextView shopTextAllpr;

    TextView shopTextAllprice;


    @BindView(R.id.shop_text_go)
    TextView shopTextGo;
    Unbinder unbinder;

    private View view;
    String data;
    int userId;
    String sessionId;

    private LinearLayoutManager linearLayoutManager;
    private ShopAdapter shopAdapter;
    private RecyclerView shopRecy;
    private SecectPresenter secectPresenter;
    private SharedPreferences sp;
    private List<SelectBean.ResultBean> result;
    private SelectBean selectBean;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.carfragment, container, false);
        initData();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initData() {
        shopRecy = view.findViewById(R.id.shop_recy);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        shopRecy.setLayoutManager(linearLayoutManager);

        SecectPresenter secectPresenter = new SecectPresenter();
        secectPresenter.SelectData(userId, sessionId);
        secectPresenter.setView(this);

        shopTextAllprice = view.findViewById(R.id.shop_text_allprice);

        shopBoxAll = view.findViewById(R.id.shop_box_all);

        shopBoxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断全选时商品的状态
                checkAll(shopBoxAll.isChecked());
                shopAdapter.notifyDataSetChanged();
            }
        });
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
        if (o instanceof SelectBean) {
            selectBean = (SelectBean) o;
            result = selectBean.getResult();
            Log.e("zzzzzzp", "" + selectBean);
            Log.e("zzzzzz", "" + result);
            shopAdapter = new ShopAdapter(getActivity(), result);
            shopRecy.setAdapter(shopAdapter);
            shopAdapter.ShopCallBack(new ShopAdapter.ShopCallBack() {
                @Override
                public void GetBack(List<SelectBean.ResultBean> bean) {
                    double totalPrice = 0;
                   int num =0;
                   int totalNum= 0;
                    for(int i= 0;i<bean.size();i++)
                    {
                        totalNum=totalNum+selectBean.getResult().get(i).getCount();
                            if(bean.get(i).isCheck())
                       {
                         totalPrice = totalPrice + (Integer.parseInt(bean.get(i).getPrice())*bean.get(i).getCount());
                       num=num+selectBean.getResult().get(i).getCount();
                       }

                    }
                    if (num<totalNum){
                        shopBoxAll.setChecked(false);
                    }else{
                        shopBoxAll.setChecked(true);
                    }
                    shopTextAllprice.setText(totalPrice+"");
                    shopTextGo.setText("去结算("+num+")");
                }



            });
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @OnClick(R.id.shop_text_go)
    public void onViewClicked() {
        String allPrice = shopTextAllprice.getText().toString();
        if (!(allPrice.equals("0"))&&!(allPrice.equals("0.0"))){
            Intent intent=new Intent(getActivity(),OrderFragment.class);
            result = new ArrayList<>();
            //判断商品是否被选中
            //如果被选中就放到集合里，通过intent传到activity中
            for (int i=0;i<selectBean.getResult().size();i++)

                if (selectBean.getResult().get(i).isCheck()) {
                    result.add(new SelectBean.ResultBean(
                            selectBean.getResult().get(i).getCommodityId(),
                            selectBean.getResult().get(i).getCommodityName(),
                            selectBean.getResult().get(i).getCount(),
                            selectBean.getResult().get(i).getPic(),
                            selectBean.getResult().get(i).getPrice()
                    ));
                }

            intent.putExtra("creation_bill", (Serializable) result);
            startActivity(intent);
        }

    }
    private void checkAll(boolean checked) {
        double totalPrice=0;
        int num=0;

        for (int i=0;i<result.size();i++){
            //遍历商品，改变状态
            result.get(i).setCheck(checked);
            totalPrice=totalPrice+(Integer.parseInt(result.get(i).getPrice())*result.get(i).getCount());
            num=num+result.get(i).getCount();
        }
        if (checked){
            shopTextAllprice.setText(""+totalPrice);
            shopTextGo.setText("去结算("+num+")");
        }else{
            shopTextAllprice.setText("0");
            shopTextGo.setText("去结算");
        }
    }
}
