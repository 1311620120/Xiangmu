package com.example.xiangmu.presenter;


import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.LoginBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.activity.LoginActivity;
import com.example.xiangmu.view.interfaces.IMainView;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 10:04:07
 * @Description:
 */
public class LoginPresenter  extends  BasePresenter<IMainView<LoginBean>>{


    private final HttpUitls instansce;

    public  LoginPresenter (LoginActivity loginActivity){
        instansce = HttpUitls.getInstance();

   }


    public  void  getLoginData(HashMap<String,String> map){
        Observable<LoginBean> login = HttpUitls.api.Login(map);
         login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<LoginBean>() {
                     @Override
                     public void accept(LoginBean loginBean) throws Exception {
                         getView().onSuccess(loginBean);
                     }
                 });
    }
}
