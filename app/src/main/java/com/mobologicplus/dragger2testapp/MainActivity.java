package com.mobologicplus.dragger2testapp;

import android.os.Bundle;

import com.mobologicplus.dragger2testapp.inject.component.ActivityComponent;
import com.mobologicplus.dragger2testapp.inject.component.ApplicationComponent;
import com.mobologicplus.dragger2testapp.inject.component.DaggerActivityComponent;
import com.mobologicplus.dragger2testapp.inject.module.ActivityModule;
import com.mobologicplus.dragger2testapp.mvp.ui.ArticleFragment;
import com.mobologicplus.dragger2testapp.util.ActivityUtil;
import com.mobologicplus.dragger2testapp.util.SharedPrefsUtil;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Inject
    public  SharedPrefsUtil sharedPrefsUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectDependency();
        if (savedInstanceState == null){
            ActivityUtil.addFragmentToActivity(getFragmentManager(), ArticleFragment.newInstance(), R.id.frame, "ArticleFragment");
        }
    }

    private void injectDependency() {
        ApplicationComponent applicationComponent = ((MainApplication)getApplication()).getApplicationComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(new ActivityModule(this))
                .build();
        activityComponent.inject(this);
    }

}
