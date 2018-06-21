package com.mp4.androidmodel.config.glide;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/**
 * Created by mopengfei on 2018-06-21.
 */

public class AppBitmapPoor implements BitmapPool {
    @Override
    public long getMaxSize() {
        return 0;
    }

    @Override
    public void setSizeMultiplier(float sizeMultiplier) {

    }

    @Override
    public void put(Bitmap bitmap) {

    }

    @NonNull
    @Override
    public Bitmap get(int width, int height, Bitmap.Config config) {
        return null;
    }

    @NonNull
    @Override
    public Bitmap getDirty(int width, int height, Bitmap.Config config) {
        return null;
    }

    @Override
    public void clearMemory() {

    }

    @Override
    public void trimMemory(int level) {

    }
}
