package com.mp4.androidmodel.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mopengfei on 2018-05-07.
 * 用来接受网络回应转换成对象后的类。
 */
public class Response<T> {
    @SerializedName("images")
    private T data;
    private boolean isSuccess;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
