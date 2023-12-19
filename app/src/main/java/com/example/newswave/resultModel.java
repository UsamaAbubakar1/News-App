package com.example.newswave;

import java.util.ArrayList;

public class resultModel {
    private String status;
    private String totalResult;

    ArrayList<articlesModel>articles;

    public resultModel(String status, String totalResult, ArrayList<articlesModel> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<articlesModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<articlesModel> articles) {
        this.articles = articles;
    }
}
