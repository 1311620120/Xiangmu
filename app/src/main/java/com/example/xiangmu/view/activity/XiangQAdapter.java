package com.example.xiangmu.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiangmu.R;
import com.example.xiangmu.applicontion.MyApplication;
import com.example.xiangmu.json.AddCarBean;
import com.example.xiangmu.json.SelectBean;
import com.example.xiangmu.json.XiangQBean;
import com.example.xiangmu.presenter.AddCarPresenter;
import com.example.xiangmu.presenter.SecectPresenter;
import com.example.xiangmu.presenter.XiangQPresenter;
import com.example.xiangmu.view.interfaces.IMainView;
import com.recker.flybanner.FlyBanner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangQAdapter extends AppCompatActivity  implements  IMainView{

    @BindView(R.id.par_image_back)
    ImageView parImageBack;
    @BindView(R.id.par_goods)
    TextView parGoods;
    @BindView(R.id.par_par)
    TextView parPar;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.layour1)
    LinearLayout layour1;
    @BindView(R.id.par_lin)
    LinearLayout parLin;
    @BindView(R.id.par_xbanner)
    FlyBanner parXbanner;
    @BindView(R.id.par_text_price)
    TextView parTextPrice;
    @BindView(R.id.par_text_num)
    TextView parTextNum;
    @BindView(R.id.par_text_name)
    TextView parTextName;
    @BindView(R.id.par_text_content)
    TextView parTextContent;
    @BindView(R.id.par_text_weight)
    TextView parTextWeight;
    @BindView(R.id.par_text_kg)
    TextView parTextKg;
    @BindView(R.id.par_text_qing)
    TextView parTextQing;
    @BindView(R.id.par_webview)
    WebView parWebview;
    @BindView(R.id.par_image_addshop)
    ImageView parImageAddshop;
    @BindView(R.id.par_image_buy)
    ImageView parImageBuy;
    private XiangQPresenter xiangQPresenter;
    private  String id;

    private SharedPreferences sp;


    private AddCarPresenter addCarPresenter;
    private SecectPresenter secectPresenter;
    private SelectBean selectBean;
    private XiangQBean xiangQBean;
    private String data1;
    private AddCarBean addCarBean;
    private int userId;
    private String sessionId;
    boolean isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qadapter);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initData();
    }

    private void initData() {
        xiangQPresenter = new XiangQPresenter(this);
        xiangQPresenter.XiangQData(id);
        Log.e("TAG",""+id);

        sp = MyApplication.getSp();
        userId = sp.getInt("userId", this.userId);
        sessionId = sp.getString("sessionId", this.sessionId);
        Log.e("bai",userId+"");
        Log.e("bai", sessionId+"" );

        xiangQPresenter.setView(this);
//        addCarPresenter = new AddCarPresenter(this);
//        addCarPresenter.setView(this);

//        secectPresenter = new SecectPresenter();
//        secectPresenter.setView(this);
//
//        parImageBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//        parImageAddshop.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//
//               secectPresenter.SelectData(userId,sessionId);
//
//           }
//       });
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof  XiangQBean){
            xiangQBean = (XiangQBean)o;
        String price = xiangQBean.getResult().getPrice();
        parTextPrice.setText("￥："+price);
        String describe = xiangQBean.getResult().getDescribe();
         parTextContent.setText(describe);
        String name = xiangQBean.getResult().getCategoryName();
        parTextName.setText(name);
        int commentNum = xiangQBean.getResult().getCommentNum();
        parTextNum.setText("已售"+commentNum+"件");
        int weight = xiangQBean.getResult().getWeight();
        parTextKg.setText(weight+"Kg");
        ArrayList<String> ban =   new ArrayList<>();
        String picture = xiangQBean.getResult().getPicture();
        id = xiangQBean.getResult().getCommodityId();
        //裁剪图片
        String[] split = picture.split("\\,");
        for (String s : split) {
            ban.add(s);
        }
        //ban轮播展示
        parXbanner.setImagesUrl(ban);
        parXbanner.startAutoPlay();

        WebSettings webSettings = parWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);                                                                 // 设置与Js交互的权限
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);                                            // 设置允许JS弹窗
        webSettings.setDomStorageEnabled(true);                                                                 //设置允许Dom存储
        webSettings.setUseWideViewPort(true);                                                           //设置加载进来的页面自适应手机屏幕
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);                                                                   // 设置可以支持缩放
        webSettings.setBuiltInZoomControls(true);                                                           // 设置出现缩放工具
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//自适应屏幕
        parWebview.loadData(xiangQBean.getResult().getDetails(), "text/html;charset=utf-8", "utf-8");                //载入js代码
        }
         parImageAddshop.setOnClickListener(new View.OnClickListener() {

             private String uid;

             @Override
             public void onClick(View v) {
                 String commodityId = xiangQBean.getResult().getCommodityId();
                 uid = commodityId + "";

                 String commodityid1 = sp.getString("commodityId", "");
                 Log.e("xxxxx",""+commodityid1);
                 //进行拆分
                 String[] split1 = commodityid1.split(",");
                 //判断 第一个 是否为空  为空 就添加
                 if(commodityid1.equals("")){
                     Log.e("my判断是否等于空","运行");
                     Toast.makeText(XiangQAdapter.this, "添加成功", Toast.LENGTH_SHORT).show();
                     SharedPreferences.Editor edit = sp.edit();
                     edit.putString("commodityId",commodityid1+","+commodityId);
                     edit.commit();
                 }else {
                     //不为空的话，循环遍历一下  是否重复
                     Log.e("mysplit", "split1=" + split1.toString());

                     for (int i = 0; i < split1.length; i++) {
                         //Log.e("my循环", "split1=i+" + split1[i]);
                         if (uid.equals(split1[i])) {
                             // Log.e("my循环里面的if", "if执行了");
                             Toast.makeText(XiangQAdapter.this, "已加入", Toast.LENGTH_SHORT).show();
                             isCheck = true;
                         }

                     }
                     //如果有不重复的 进行添加
                     if (!isCheck) {
                         Toast.makeText(XiangQAdapter.this, "添加成功", Toast.LENGTH_SHORT).show();
                         //Log.e("mybool", "执行了");
                         SharedPreferences.Editor edit = sp.edit();
                         edit.putString("commodityId", commodityid1 + "," + commodityId);
                         edit.commit();
                     }
                 }
             }
        });
//        if (o instanceof AddCarBean){
//            addCarBean = (AddCarBean)o;
//        }
//        if (o instanceof SelectBean){
//            selectBean = (SelectBean)o;
//            List<SelectBean.ResultBean> result = selectBean.getResult();
//
//            if (selectBean.getStatus().equals("0000")){
//                    ArrayList<TongBean> list = new ArrayList<>();
//
//                    for (SelectBean.ResultBean results:result){
//                     list.add(new TongBean(results.getCommodityId(),results.getCount()));
//                    }
//                    String string = "[";
//                    if (list.size()==0){
//                        list.add(new TongBean(id,1));
//                    }else {
//                        for (int i=0; i<list.size();i++){
//                            if (id == list.get(i).getCommodityId()){
//                                int count =list.get(i).getCount();
//                                count++;
//                                list.get(i).setCount(count);
//                                break;
//                            }else  if (i == list.size()-1){
//                                list.add(new TongBean(id,1));
//                                break;
//                            }
//                        }
//                    }
//                     for (TongBean goods:list){
//                        string +="{\"commodityId\":"+goods.getCommodityId()+ ",\"count\":" + goods.getCount() + "},";
//                     }
//                     String subString =string.substring(0,string.length()-1);
//                     subString+="]";
//                    HashMap<String, String> map = new HashMap<>();
//                    data1 = map.put("data", subString);
//                   Log.e("DDDDDDDDDD",data1);
//                addCarPresenter.AddCatData(this.userId, this.sessionId,data1);
//                }
//
//        }
    }


    @Override
    public void onFail(String str) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
      public void getEventBus(String sid){
        id=sid;
      }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
