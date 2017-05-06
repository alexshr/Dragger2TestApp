package com.mobologicplus.dragger2testapp.mvp.model;

/**
 * Created by sunil on 5/3/2017.
 */

public class Article {

    private String articleName;
    private String articleDescription;

    public Article(){

    }

    public Article(String articleName, String articleDescription) {
        this.articleName = articleName;
        this.articleDescription = articleDescription;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleDescription() {
        return articleDescription;
    }
}
