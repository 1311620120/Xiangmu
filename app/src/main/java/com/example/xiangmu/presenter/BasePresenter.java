package com.example.xiangmu.presenter;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 09:13:47
 * @Description:
 */
public class BasePresenter<V> {
    private  V view;

    public void setView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
    public  void  detachView(){
        this.view=null;
    }
}
