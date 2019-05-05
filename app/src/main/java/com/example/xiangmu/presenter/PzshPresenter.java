package com.example.xiangmu.presenter;

import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.PzshBean;
import com.example.xiangmu.json.RxxpBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.activity.PzssActivity;
import com.example.xiangmu.view.activity.RxxpActivity;
import com.example.xiangmu.view.interfaces.IMainView;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/16 19:10:45
 * @Description:
 */
public class PzshPresenter extends BasePresenter<IMainView<PzshBean>> {

     private final HttpUitls instance;

     public PzshPresenter(PzssActivity pzssActivity){
          instance = HttpUitls.getInstance();
     }

     public  void ShowData(String labelId,int page,int count){
         final Observable<PzshBean> pzsh = instance.api.Pzsh(labelId,page,count);
         pzsh.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<PzshBean>() {
                     @Override
                     public void accept(PzshBean pzshBean) throws Exception {
                         getView().onSuccess(pzshBean);
                     }
                 });

     }

}
