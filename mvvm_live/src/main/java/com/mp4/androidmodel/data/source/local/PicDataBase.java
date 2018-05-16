package com.mp4.androidmodel.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mp4.androidmodel.data.entity.Picture;

/**
 * 创建Picture.db数据库，并根据{@link Picture}在数据库中创建表
 * Created by mopengfei on 2018-05-14.
 */
@Database(entities = {Picture.class}, version = 1, exportSchema = false)
public abstract class PicDataBase extends RoomDatabase {
    private static PicDataBase INSTANCE;

    public abstract PictureDao pictureDao();

    private static final Object sLock = new Object();

    public static PicDataBase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PicDataBase.class, "Picture.db").build();
            }
            return INSTANCE;
        }
    }

}
