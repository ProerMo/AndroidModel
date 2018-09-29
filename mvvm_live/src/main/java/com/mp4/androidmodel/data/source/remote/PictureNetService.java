package com.mp4.androidmodel.data.source.remote;

import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * retorfit的service，可设置请求参数并发送网络请求
 * format=js&idx=0&n=1&mkt=zh-CN
 * Created by mopengfei on 2018-05-16.
 */

public interface PictureNetService {
    @GET("HPImageArchive.aspx")
    Observable<Response<List<Picture>>> getPicFromNet(@Query("idx") int idx, @Query("n") int picSize);

}
