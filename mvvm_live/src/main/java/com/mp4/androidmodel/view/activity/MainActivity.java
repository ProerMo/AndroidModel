package com.mp4.androidmodel.view.activity;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mp4.androidmodel.R;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;
import com.mp4.androidmodel.data.source.remote.RemotePicRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }
    //TODO 测试通过，能拿到数据！！05-16 20:43 此处代码待删除！
    public void getData(){
//        new RemotePicRepository().getPicFormNet(4)
//                .observe(this, new Observer<Response<List<Picture>>>() {
//                    @Override
//                    public void onChanged(@Nullable Response<List<Picture>> listResponse) {
//                        Log.d("mmmm", "onChanged: "+listResponse.getData().get(0).getUrl());
//                    }
//                });
    }
}
