package com.levibostian.pantrypirate.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtil {

    public static Bitmap createBitmap(int resource, Context context) {
        return BitmapFactory.decodeResource(context.getResources(), resource);
    }
}
