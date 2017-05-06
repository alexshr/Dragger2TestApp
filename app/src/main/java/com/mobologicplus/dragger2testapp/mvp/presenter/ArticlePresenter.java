package com.mobologicplus.dragger2testapp.mvp.presenter;


import com.google.gson.Gson;
import com.mobologicplus.dragger2testapp.mvp.contract.ArticleContract;
import com.mobologicplus.dragger2testapp.mvp.model.Article;
import com.mobologicplus.dragger2testapp.util.SharedPrefsUtil;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sunil on 5/3/2017.
 */

public class ArticlePresenter implements ArticleContract.Presenter{

    private ArticleContract.View mView;
    private CompositeDisposable mCompositeSubscription;

    public ArticlePresenter( ) {
    }


    @Override
    public void attachView(ArticleContract.View view) {
        mView = view;
        mCompositeSubscription = new CompositeDisposable();

    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        mCompositeSubscription.clear();
    }

    @Override
    public void addArticle(Article article, SharedPrefsUtil sharedPrefsUtil) {
        // store this article into sharedPreference
        Gson gson = new Gson();
        String jsonArticle = gson.toJson(article);
        sharedPrefsUtil.put(SharedPrefsUtil.PREF_KEY, jsonArticle);
        mView.onSavedArticle();
    }

    @Override
    public void showArticle(SharedPrefsUtil sharedPrefsUtil) {
        Gson gson = new Gson();
        String articleString = sharedPrefsUtil.get(SharedPrefsUtil.PREF_KEY, "");
        Article articleObj = gson.fromJson(articleString, Article.class);
        mView.onLoadArticleOk(articleObj);
    }
}
