package com.example.xiangmu.presenter;

import android.util.Log;

import com.example.xiangmu.json.SelectBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.interfaces.IMainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/19 16:34:03
 * @Description:
 */
public class SecectPresenter extends  BasePresenter<IMainView<SelectBean>> {

    private final HttpUitls instance;

    public  SecectPresenter (){
        instance = HttpUitls.getInstance();
      }
       public void SelectData(int userId,String sessionId){
           Observable<SelectBean> select = instance.api.Select(userId,sessionId);
           select.subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new Consumer<SelectBean>() {
                       @Override
                       public void accept(SelectBean selectBean) throws Exception {
                    //       Log.e("nhj", "查询成功 "+selectBean.getMessage());
                           getView().onSuccess(selectBean);
                       }
                   }, new Consumer<Throwable>() {
                       @Override
                       public void accept(Throwable throwable) throws Exception {
                           Log.e("nhj", "查询失败 "+throwable.toString());
                       }
                   });
       }
}
