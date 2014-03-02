package com.levibostian.pantrypirate.vo;

public class License {
    private String mTitle;
    private String mUrl;

    public License(String title, String url) {
        mTitle = title;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }
}
