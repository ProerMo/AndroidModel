package com.mp4.androidmodel.config.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by mopengfei on 2018-06-21.
 */
@GlideModule
public class AndroidGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);
//        builder.setBitmapPool()
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);

    }
}
