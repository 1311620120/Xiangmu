package com.example.xiangmu.presenter;

import com.example.xiangmu.applicontion.Constant;
import com.example.xiangmu.json.BannerJson;
import com.example.xiangmu.model.HttpUitls;
import com.example.xiangmu.view.frangment.HomeFragment;
import com.example.xiangmu.view.interfaces.IMainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 18:53:17
 * @Description:
 */
public class BannerPresenter extends BasePresenter<IMainView<BannerJson>> {

    private final HttpUitls instance;

    public  BannerPresenter(HomeFragment homeFragment){
        instance = HttpUitls.getInstance();
    }
    public void   BannerData(){
        Observable<BannerJson> banner = instance.api.banner();
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerJson>() {
                    @Override
                    public void accept(BannerJson bannerJson) throws Exception {
                        getView().onSuccess(bannerJson);
                    }
                });
    }
}
