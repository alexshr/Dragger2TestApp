package com.mobologicplus.dragger2testapp.inject.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 5/4/2017.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }


    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
