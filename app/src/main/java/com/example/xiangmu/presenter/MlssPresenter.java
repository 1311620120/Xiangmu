package com.example.xiangmu.presenter;

import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.MlssBean;
import com.example.xiangmu.json.RxxpBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.activity.MlssActivity;
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
public class MlssPresenter extends BasePresenter<IMainView<MlssBean>> {

     private final HttpUitls instance;

     public MlssPresenter(MlssActivity mlssActivity){
          instance = HttpUitls.getInstance();
     }

     public  void ShowData(String labelId,int page,int count){
         Observable<MlssBean> mlss = instance.api.Mlss(labelId,page,count);
         mlss.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<MlssBean>() {
                     @Override
                     public void accept(MlssBean mlssBean) throws Exception {
                          getView().onSuccess(mlssBean);
                     }
                 });
     }

}
