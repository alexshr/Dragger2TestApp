package com.mobologicplus.dragger2testapp.inject.component;

import android.app.Application;

import com.mobologicplus.dragger2testapp.MainApplication;
import com.mobologicplus.dragger2testapp.inject.module.ApplicationModule;
import com.mobologicplus.dragger2testapp.util.SharedPrefsUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunil on 5/3/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication mainApplication);

    Application getApplication();

    SharedPrefsUtil getSharedPrefsUtil();

}
