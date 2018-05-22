package com.mp4.androidmodel.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mp4.androidmodel.R;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;
import com.mp4.androidmodel.data.source.remote.RemotePicRepository;
import com.mp4.androidmodel.viewmodel.MainViewModel;
import com.mp4.androidmodel.viewmodel.ViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = obtainViewModel(this);
        getData();
    }


    public void getData() {
        mViewModel.getListFromRemote(10,this);
    }

    public static MainViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel.class);
    }
}
