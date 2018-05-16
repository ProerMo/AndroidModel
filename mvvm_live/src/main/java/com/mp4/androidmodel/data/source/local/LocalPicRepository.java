package com.mp4.androidmodel.data.source.local;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mp4.androidmodel.data.entity.Page;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.source.PicDataSource;

import java.util.List;

/**
 * 本地数据源，直接对数据库进行操作
 * Created by mopengfei on 2018-05-14.
 */

public class LocalPicRepository implements PicDataSource.LocalDataSource {

    private static volatile LocalPicRepository INSTANCE;

    private PictureDao mPictureDao;

    private LocalPicRepository(@NonNull PictureDao pictureDao) {
        mPictureDao = pictureDao;
    }

    public static LocalPicRepository getInstance(@NonNull PictureDao pictureDao) {
        if (INSTANCE == null) {
            synchronized (LocalPicRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalPicRepository(pictureDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Picture>> getAllPicFromDb() {
        return mPictureDao.selectAllPictureFromDb();
    }

    @Override
    public LiveData<Page<Picture>> getPicPageFromDb(int pageNo, int pageSize) {
        //TODO 怎么做比较好？？？？？
        return null;
    }

    @Override
    public LiveData<Integer> deletePicFromDbByIds(int... id) {
        return null;
//        return mPictureDao.deletePictureFromDbById(id);
    }

    @Override
    public LiveData<Integer> deleteAllPicFromDb() {
        //TODO ????
        return null;
    }

    @Override
    public LiveData<Integer> updatePicFromDb(Picture... pictures) {
        return null;
//        return mPictureDao.updatePictureFromDb(pictures);
    }

    @Override
    public LiveData<List<Long>> addPicToDb(Picture... pictures) {
        return null;
//        return mPictureDao.insertPicturesIntoDb(pictures);
    }
}
