package com.mp4.androidmodel.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mp4.androidmodel.R;
import com.mp4.androidmodel.data.entity.NotnullObserver;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.view.adapter.PicListAdapter;
import com.mp4.androidmodel.view.widget.GridSpaceItemDecoration;
import com.mp4.androidmodel.viewmodel.MainViewModel;
import com.mp4.androidmodel.viewmodel.ViewModelFactory;

import java.util.List;

public class MyCollectActivity extends AppCompatActivity implements PicListAdapter.OnCollectListener {

    private PicListAdapter mAdapter;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = obtainViewModel(this);
        setContentView(R.layout.activity_my_collect);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpaceItemDecoration(10));
        mAdapter = new PicListAdapter(null, this);
        mViewModel.getAllPicFromDb()
                .observe(this, new NotnullObserver<List<Picture>>() {
                    @Override
                    public void onNotNullChanged(List<Picture> pictures) {
                        for (Picture picture : pictures) {
                            picture.setChecked(true);
                        }
                        mAdapter.setmPictureList(pictures);
                    }
                });
        recyclerView.setAdapter(mAdapter);
    }

    public static MainViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory viewModelFactory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel.class);
    }

    @Override
    public void onCollect(Picture picture, int posit) {

    }

    @Override
    public void onDisCollect(Picture picture, int posit) {
        mAdapter.remove(picture);
    }
}
