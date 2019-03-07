package com.mobologicplus.dragger2testapp.mvp.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobologicplus.dragger2testapp.MainActivity;
import com.mobologicplus.dragger2testapp.MainApplication;
import com.mobologicplus.dragger2testapp.R;
import com.mobologicplus.dragger2testapp.inject.component.ApplicationComponent;
import com.mobologicplus.dragger2testapp.inject.component.ArticleComponent;
import com.mobologicplus.dragger2testapp.inject.component.DaggerArticleComponent;
import com.mobologicplus.dragger2testapp.inject.module.ArticleModule;
import com.mobologicplus.dragger2testapp.mvp.contract.ArticleContract;
import com.mobologicplus.dragger2testapp.mvp.model.Article;
import com.mobologicplus.dragger2testapp.util.SharedPrefsUtil;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sunil on 5/3/2017.
 */

public class ArticleFragment extends Fragment implements ArticleContract.View {

    @BindView(R.id.title)
    EditText titleEditText;
    @BindView(R.id.description)
    EditText descriptionEditText;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.show)
    Button show;
    @BindView(R.id.titleView)
    TextView titleView;
    @BindView(R.id.descView)
    TextView descView;
    private View mRootView;

    SharedPrefsUtil sharedPrefsUtil;

    @Inject
    ArticleContract.Presenter mPresenter;

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependency();
        mPresenter.attachView(this);
    }

    private void injectDependency() {
        ApplicationComponent applicationComponent = ((MainApplication) getActivity().getApplication()).getApplicationComponent();
        ArticleComponent articleComponent = DaggerArticleComponent.builder()
                .applicationComponent(applicationComponent)
                .articleModule(new ArticleModule())
                .build();
        articleComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, mRootView);
        sharedPrefsUtil = ((MainActivity)getActivity()).sharedPrefsUtil;
        return mRootView;
    }

    @OnClick(R.id.add)
    public void addArticleClick() {
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        if (title.isEmpty() && description.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter details", Toast.LENGTH_LONG).show();
        } else {
            Article article = new Article(title, description);
            mPresenter.addArticle(article, sharedPrefsUtil);
        }
    }

    @OnClick(R.id.show)
    public void showArticleClick() {
        mPresenter.showArticle(sharedPrefsUtil);
    }


    @Override
    public void onLoadArticleOk(Article article) {
        titleView.setText("Title: "+article.getArticleName());
        descView.setText("Description: "+ article.getArticleDescription());
    }

    @Override
    public void onSavedArticle() {
     Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
    }
}
