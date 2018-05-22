package com.mp4.androidmodel.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.mp4.androidmodel.data.source.local.LocalPicRepository;
import com.mp4.androidmodel.data.source.local.PicDataBase;
import com.mp4.androidmodel.data.source.remote.RemotePicRepository;

/**
 * Created by mopengfei on 2018-05-21.
 */

public class ViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    private static volatile ViewModelFactory INSTANCE;
    private Application mApplication;
    private RemotePicRepository mRemotePicRepository;
    private LocalPicRepository mLocalPicRepository;

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    LocalPicRepository localPicRepository = LocalPicRepository.getInstance(
                            PicDataBase.getInstance(application.getApplicationContext()).pictureDao());
                    RemotePicRepository remotePicRepository = RemotePicRepository.getInstance();
                    INSTANCE = new ViewModelFactory(application, localPicRepository, remotePicRepository);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates a {@code AndroidViewModelFactory}
     *
     * @param application an application to pass in {@link AndroidViewModel}
     */
    private ViewModelFactory(@NonNull Application application,
                             LocalPicRepository localPicRepository, RemotePicRepository remotePicRepository) {
        super(application);
        mApplication = application;
        mLocalPicRepository = localPicRepository;
        mRemotePicRepository = remotePicRepository;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(mApplication, mLocalPicRepository, mRemotePicRepository);
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
