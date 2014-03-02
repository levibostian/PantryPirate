package com.levibostian.pantrypirate.vo;

import android.content.Context;
import android.graphics.Bitmap;
import com.levibostian.pantrypirate.util.ImageUtil;

public class FoodItem {
    private String mTitle;
    private int mImage;

    public FoodItem(String title, int image) {
        mTitle = title;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImageResource() {
        return mImage;
    }

    public Bitmap getBitmap(Context context) {
        return ImageUtil.createBitmap(mImage, context);
    }
}
