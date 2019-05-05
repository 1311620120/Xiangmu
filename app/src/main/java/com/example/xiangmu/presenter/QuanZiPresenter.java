package com.example.xiangmu.presenter;

import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.QuanJson;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.frangment.EvaluateFragment;
import com.example.xiangmu.view.interfaces.IMainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/17 11:27:23
 * @Description:
 */
public class QuanZiPresenter extends  BasePresenter<IMainView<QuanJson>> {

    private final HttpUitls instance;

    public QuanZiPresenter(EvaluateFragment evaluateFragment){
        instance = HttpUitls.getInstance();

    }

    public void   QuanData(int page, int count){
        Observable<QuanJson> quan = instance.api.Quan(page, count);
        quan.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<QuanJson>() {
                    @Override
                    public void accept(QuanJson quanJson) throws Exception {
                        getView().onSuccess(quanJson);
                    }
                });

    }
}
