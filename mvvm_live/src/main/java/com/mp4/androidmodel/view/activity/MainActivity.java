package com.mp4.androidmodel.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.mp4.androidmodel.R;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;
import com.mp4.androidmodel.databinding.ActivityMainBinding;
import com.mp4.androidmodel.view.adapter.PicListAdapter;
import com.mp4.androidmodel.viewmodel.MainViewModel;
import com.mp4.androidmodel.viewmodel.ViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private ActivityMainBinding mBinding;
    private PicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mViewModel = obtainViewModel(this);
        mAdapter = new PicListAdapter(null);
        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        getData();
    }


    public void getData() {
        mViewModel.getListFromRemote(10, this)
                .observe(this, new Observer<Response<List<Picture>>>() {
                    @Override
                    public void onChanged(@Nullable Response<List<Picture>> listResponse) {
                        if (listResponse != null)
                            mAdapter.setmPictureList(listResponse.getData());
                    }
                });
    }

    public static MainViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel.class);
    }
}
