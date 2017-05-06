package com.mobologicplus.dragger2testapp.inject.component;

import com.mobologicplus.dragger2testapp.MainActivity;
import com.mobologicplus.dragger2testapp.inject.module.ActivityModule;
import com.mobologicplus.dragger2testapp.inject.scope.PerActivity;

import dagger.Component;

/**
 * Created by sunil on 5/4/2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
