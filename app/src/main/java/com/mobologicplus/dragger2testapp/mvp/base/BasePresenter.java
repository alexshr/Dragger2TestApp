package com.mobologicplus.dragger2testapp.mvp.base;

/**
 * Created by sunil on 5/3/2017.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void subscribe();

    void unSubscribe();
}
