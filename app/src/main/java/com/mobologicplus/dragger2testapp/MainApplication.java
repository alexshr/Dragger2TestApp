package com.mobologicplus.dragger2testapp;

import android.app.Application;
import android.content.Context;

import com.mobologicplus.dragger2testapp.inject.component.ApplicationComponent;
import com.mobologicplus.dragger2testapp.inject.component.DaggerApplicationComponent;
import com.mobologicplus.dragger2testapp.inject.module.ApplicationModule;

/**
 * Created by sunil on 5/3/2017.
 */

public class MainApplication extends Application{

    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupInjector();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    private void setupInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }
}
