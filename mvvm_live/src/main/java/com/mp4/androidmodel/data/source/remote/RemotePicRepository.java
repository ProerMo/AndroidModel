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
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mopengfei on 2018-05-16.
 */

public class RemotePicRepository implements PicDataSource.RemoteDataSource {

    private static Retrofit retrofit;
    private static volatile RemotePicRepository INSTANCE;

    public static RemotePicRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (RemotePicRepository.class) {
                INSTANCE = new RemotePicRepository();
            }
        }
        return INSTANCE;
    }

    private RemotePicRepository() {
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
                .getPicFromNet(2, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<List<Picture>>>() {
                    @Override
                    public void accept(Response<List<Picture>> listResponse) throws Exception {
                        liveData.postValue(listResponse);
                    }
                });
        return liveData;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
