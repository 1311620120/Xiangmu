package com.example.xiangmu.presenter;

import android.util.Log;

import com.example.xiangmu.json.XiangQBean;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.activity.XiangQAdapter;
import com.example.xiangmu.view.interfaces.IMainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/18 15:32:41
 * @Description:
 */
public class XiangQPresenter extends  BasePresenter<IMainView<XiangQBean>>
{
    private final HttpUitls instance;

    public  XiangQPresenter(XiangQAdapter xiangQAdapter){
          instance = HttpUitls.getInstance();
     }

     public void XiangQData(String id){
         Observable<XiangQBean> XiangQ = instance.api.XiangQ(id);
         XiangQ.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<XiangQBean>() {
                     @Override
                     public void accept(XiangQBean xiangQBean) throws Exception {
                         Log.e("EEEEE",""+xiangQBean.getResult().getCommodityId());
                         getView().onSuccess(xiangQBean);



                     }
                 });
     }
}
