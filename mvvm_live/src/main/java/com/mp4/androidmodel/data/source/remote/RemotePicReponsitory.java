package com.mp4.androidmodel.data.source.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;
import com.mp4.androidmodel.data.source.PicDataSource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mopengfei on 2018-05-16.
 */

public class RemotePicReponsitory implements PicDataSource.RemoteDataSource {

    private Retrofit retrofit;

    public RemotePicReponsitory() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ParamInterceptor())
                .connectTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://www.bing.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Override
    public LiveData<Response<List<Picture>>> getPicFormNet(int count) {
        final MutableLiveData<Response<List<Picture>>> liveData = new MutableLiveData<>();
        getRetrofit().create(PictureNetService.class)
                .getPicFromNet(1, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<Picture>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<List<Picture>> pictureResponse) {
                        liveData.postValue(pictureResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return liveData;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static void main(String[] args) {

    }
}
