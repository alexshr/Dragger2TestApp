package com.mobologicplus.dragger2testapp.inject.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.mobologicplus.dragger2testapp.MainApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 5/3/2017.
 */

@Module
public class ApplicationModule {

    private final MainApplication mainApplication;

    public ApplicationModule(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @Provides
    public Application provideApplication() {
        return mainApplication;
    }


    @Provides
    SharedPreferences provideSharedPrefs() {
        return mainApplication.getSharedPreferences("dragger-prefs", Context.MODE_PRIVATE);
    }
}
