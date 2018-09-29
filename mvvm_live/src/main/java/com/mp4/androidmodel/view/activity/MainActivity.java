package com.mp4.androidmodel.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mp4.androidmodel.R;
import com.mp4.androidmodel.data.entity.NotnullObserver;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;
import com.mp4.androidmodel.databinding.ActivityMainBinding;
import com.mp4.androidmodel.view.adapter.PicListAdapter;
import com.mp4.androidmodel.view.widget.GridSpaceItemDecoration;
import com.mp4.androidmodel.viewmodel.MainViewModel;
import com.mp4.androidmodel.viewmodel.ViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PicListAdapter.OnCollectListener {

    private MainViewModel mViewModel;
    private ActivityMainBinding mBinding;
    private PicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mViewModel = obtainViewModel(this);
        mAdapter = new PicListAdapter(null, this);
        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.recyclerView.addItemDecoration(new GridSpaceItemDecoration(10));
        getData();
    }


    public void getData() {
        mViewModel.getListFromRemote(100, this)
                .observe(this, new Observer<Response<List<Picture>>>() {
                    @Override
                    public void onChanged(@Nullable Response<List<Picture>> listResponse) {
                        if (listResponse != null) {
                            mAdapter.setmPictureList(listResponse.getData());
                        }
                    }
                });
    }

    public void addData() {
        mViewModel.getListFromRemote(100, this)
                .observe(this, new Observer<Response<List<Picture>>>() {
                    @Override
                    public void onChanged(@Nullable Response<List<Picture>> listResponse) {
                        if (listResponse != null) {
                            mAdapter.getmPictureList().addAll(listResponse.getData());
                        }
                    }
                });
    }


    public static MainViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel.class);
    }

    @Override
    public void onCollect(Picture picture, int posit) {
        mViewModel.collectPicture(picture).observe(this, new NotnullObserver<List<Long>>() {
            @Override
            public void onNotNullChanged(List<Long> longs) {
                if (longs.size() > 0)
                    Toast.makeText(MainActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDisCollect(Picture picture, int posit) {
        mViewModel.disCollectPicture(picture).observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer == null) {
                    return;
                }
                if (integer == 1) {
                    Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my_collect:
                startActivity(new Intent(this, MyCollectActivity.class));
                return true;
            case R.id.setting:
                startActivity(new Intent(this, SettingActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
