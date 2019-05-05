package com.example.xiangmu.presenter;

import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.ShowJson;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.frangment.HomeFragment;
import com.example.xiangmu.view.interfaces.IMainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 08:42:15
 * @Description:
 */
public class HomePresenter extends BasePresenter<IMainView<ShowJson>> {

    private final HttpUitls instance;

    public  HomePresenter (HomeFragment homeFragment){
        instance = HttpUitls.getInstance();

    }

    public  void  HomeData(){
        final Observable<ShowJson> show = instance.api.show();
        show.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowJson>() {
                    @Override
                    public void accept(ShowJson showJson) throws Exception {
                        getView().onSuccess(showJson);
                    }
                });
    }
}
