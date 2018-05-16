package com.mp4.androidmodel.data.source.remote;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mopengfei on 2018-05-16.
 */

public class ParamInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        HttpUrl.Builder builder = request.url().newBuilder();
        builder.addQueryParameter("format", "js");
        builder.addQueryParameter("mkt", "zh-CN");
        requestBuilder.url(builder.build());
        request = requestBuilder.build();
        return chain.proceed(request);
    }
}
