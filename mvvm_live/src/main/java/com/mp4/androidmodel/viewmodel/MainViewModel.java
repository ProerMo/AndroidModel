package com.mp4.androidmodel.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

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

    public MainViewModel(@NonNull Application application, LocalPicRepository localDataSources, RemotePicRepository remoteDataSource) {
        super(application);
        mLocalPicRepository = localDataSources;
        mRemotePicRepository = remoteDataSource;
    }

    //TODO ?????? liveData的转换还不了解
    public LiveData<List<Picture>> getListFromRemote(int count) {
        return Transformations.switchMap(mRemotePicRepository.getPicFormNet(count), new Function<Response<List<Picture>>, LiveData<List<Picture>>>() {
            @Override
            public LiveData<List<Picture>> apply(Response<List<Picture>> input) {
                MutableLiveData<List<Picture>> liveData = new MutableLiveData<>();
                liveData.postValue(input.getData());
                return liveData;
            }
        });
    }
}
