package com.example.xiangmu.presenter;


import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.RegBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.activity.RegActivity;
import com.example.xiangmu.view.interfaces.IMainView;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 10:04:23
 * @Description:
 */
public class RegPersenter extends BasePresenter<IMainView<RegBean>>{

    private final HttpUitls instansce;

    public RegPersenter(RegActivity regActivity){
        instansce = HttpUitls.getInstance();

     }
         public  void  getRegData(HashMap<String,String > map){
             Observable<RegBean> reg = instansce.api.Reg(map);
             reg.subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Consumer<RegBean>() {
                         @Override
                         public void accept(RegBean regBean) throws Exception {
                             getView().onSuccess(regBean);
                         }
                     });
         }
}
