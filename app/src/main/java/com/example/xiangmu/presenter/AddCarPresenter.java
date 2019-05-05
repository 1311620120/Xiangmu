package com.example.xiangmu.presenter;

import android.util.Log;

import com.example.xiangmu.json.AddCarBean;

import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.frangment.CarFragment;
import com.example.xiangmu.view.interfaces.IMainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/19 16:45:45
 * @Description:
 */
public class AddCarPresenter extends BasePresenter<IMainView<AddCarBean>> {

    private final HttpUitls instance;

    public  AddCarPresenter(){
        instance = HttpUitls.getInstance();
     }
     public  void  AddCatData(int userId,String sessionId,String data){
         Observable<AddCarBean> addCar = instance.api.AddCar(userId,sessionId, data);
         addCar.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<AddCarBean>() {
                     @Override
                     public void accept(AddCarBean addCarBean) throws Exception {
                         getView().onSuccess(addCarBean);
                     }
                 }, new Consumer<Throwable>() {
                     @Override
                     public void accept(Throwable throwable) throws Exception {
                         Log.e("nhj", "accept: "+throwable.toString() );
                     }
                 });
     }

    public void put() {
    }
}
