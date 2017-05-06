package com.mobologicplus.dragger2testapp.inject.module;

import com.mobologicplus.dragger2testapp.mvp.contract.ArticleContract;
import com.mobologicplus.dragger2testapp.mvp.model.Article;
import com.mobologicplus.dragger2testapp.mvp.presenter.ArticlePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 5/3/2017.
 */
@Module
public class ArticleModule {

    @Provides
    Article getArticle() {
        return new Article();
    }


    @Provides
    ArticleContract.Presenter getArticlesPresenter() {
        return new ArticlePresenter();
    }
}
