package com.mp4.androidmodel.data.entity;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

/**
 * Created by mopengfei on 2018-08-13.
 */

public abstract class NotnullObserver<T> implements Observer<T> {

    public abstract void onNotNullChanged(T t);

    @Override
    public void onChanged(@Nullable T o) {
        if (o != null)
            onNotNullChanged(o);
    }
}
