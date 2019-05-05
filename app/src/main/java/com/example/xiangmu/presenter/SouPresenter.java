package com.example.xiangmu.presenter;

import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.SouBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.frangment.HomeFragment;
import com.example.xiangmu.view.interfaces.IMainView;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/17 00:30:20
 * @Description:
 */
public class SouPresenter extends BasePresenter<IMainView<SouBean>> {

    private final HttpUitls instance;

    public  SouPresenter(HomeFragment homeFragment){
        instance = HttpUitls.getInstance();

     }

         public  void ShuData(String keyword,int page,int count) {
             Observable<SouBean> sou = instance.api.Sou(keyword,page,count);
             sou.subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Consumer<SouBean>() {
                         @Override
                         public void accept(SouBean souBean) throws Exception {
                             getView().onSuccess(souBean);
                         }
                     });
         }
     }

