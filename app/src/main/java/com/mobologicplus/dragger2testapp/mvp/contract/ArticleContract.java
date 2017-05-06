package com.mobologicplus.dragger2testapp.mvp.contract;

import android.content.Context;

import com.mobologicplus.dragger2testapp.mvp.base.BasePresenter;
import com.mobologicplus.dragger2testapp.mvp.base.BaseView;
import com.mobologicplus.dragger2testapp.mvp.model.Article;
import com.mobologicplus.dragger2testapp.util.SharedPrefsUtil;

import java.util.List;

/**
 * Created by sunil on 5/3/2017.
 */

public class ArticleContract {

    public interface View extends BaseView{

        void onLoadArticleOk(Article article);
        void onSavedArticle();

    }

    public interface Presenter extends BasePresenter<View> {

        void addArticle(Article article, SharedPrefsUtil sharedPrefsUtil);

        void showArticle(SharedPrefsUtil sharedPrefsUtil);

    }
}
