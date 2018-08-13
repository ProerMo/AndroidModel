package com.mp4.androidmodel.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;
import com.mp4.androidmodel.data.source.local.LocalPicRepository;
import com.mp4.androidmodel.data.source.remote.RemotePicRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mopengfei on 2018-05-21.
 */

public class MainViewModel extends AndroidViewModel {
    private RemotePicRepository mRemotePicRepository;
    private LocalPicRepository mLocalPicRepository;
    ObservableList<Picture> mPictures = new ObservableArrayList<>();

    public MainViewModel(@NonNull Application application, LocalPicRepository localDataSources, RemotePicRepository remoteDataSource) {
        super(application);
        mLocalPicRepository = localDataSources;
        mRemotePicRepository = remoteDataSource;
    }

    public LiveData<Response<List<Picture>>> getListFromRemote(int count, AppCompatActivity activity) {
        return mRemotePicRepository.getPicFormNet(count);
    }

    public MutableLiveData<List<Long>> collectPicture(final Picture... picture) {
        final MutableLiveData<List<Long>> liveData = new MutableLiveData<>();
        Observable.create(new ObservableOnSubscribe<List<Long>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Long>> emitter) throws Exception {
                emitter.onNext(mLocalPicRepository.addPicToDb(picture));
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<List<Long>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Long> o) {
                        liveData.postValue(o);
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

    public MutableLiveData<Integer> disCollectPicture(final Picture picture) {
        final MutableLiveData<Integer> liveData = new MutableLiveData<>();
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(mLocalPicRepository.deletePicFromDbByIds(picture.getId()));
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer o) {
                        liveData.postValue(o);
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

    public LiveData<List<Picture>> getAllPicFromDb() {
        return mLocalPicRepository.getAllPicFromDb();

    }
}
