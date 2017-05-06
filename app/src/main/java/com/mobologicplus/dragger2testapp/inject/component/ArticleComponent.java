package com.mobologicplus.dragger2testapp.inject.component;

import com.mobologicplus.dragger2testapp.inject.module.ArticleModule;
import com.mobologicplus.dragger2testapp.inject.scope.PerActivity;
import com.mobologicplus.dragger2testapp.mvp.ui.ArticleFragment;

import dagger.Component;

/**
 * Created by sunil on 5/3/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ArticleModule.class)
public interface ArticleComponent {
    void inject(ArticleFragment mainFragment);
}
