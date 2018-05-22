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
        LiveData<Response<List<Picture>>> liveData = mRemotePicRepository.getPicFormNet(count);
        liveData.observe(activity, new Observer<Response<List<Picture>>>() {
            @Override
            public void onChanged(@Nullable Response<List<Picture>> listResponse) {
                mPictures.addAll(listResponse.getData());
            }
        });
        return liveData;
    }
}
