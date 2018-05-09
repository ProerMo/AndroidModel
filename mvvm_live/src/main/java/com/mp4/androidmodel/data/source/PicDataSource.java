package com.mp4.androidmodel.data.source;

import android.arch.lifecycle.LiveData;

import com.mp4.androidmodel.data.entity.Page;
import com.mp4.androidmodel.data.entity.Picture;
import com.mp4.androidmodel.data.entity.Response;

import java.util.List;

/**
 * Created by mopengfei on 2018-05-07.
 * 图片数据源接口
 */
public class PicDataSource {
    /**
     * 本地图片数据源操作接口（包括数据库和本地文件//TODO 未做 05-09 19:47）
     */
    public interface LocalDataSource {

        /**
         * 获取数据库中所有图片对象
         *
         * @return
         */
        LiveData<List<Picture>> getAllPicFromDb();

        /**
         * 从数据库中分页获取图片信息
         *
         * @param pageNo
         * @param pageSize
         * @return
         */
        LiveData<Page<Picture>> getPicPageFromDb(int pageNo, int pageSize);

        /**
         * 根据id从数据库中删除单个或多个图片对象，返回值是删除的条数
         *
         * @param id
         * @return
         */
        LiveData<Integer> deletePicFromDbByIds(int... ids);

        /**
         * 把数据库中所有图片对象删除，返回值是删除的条数
         *
         * @return
         */
        LiveData<Integer> deleteAllPicFromDb();

        /**
         * 修改单个或多个图片对象，返回值是更改的数据条数
         *
         * @param pictures
         * @return
         */
        LiveData<Integer> updatePicFromDb(Picture... pictures);

        /**
         * 往表中插入一条或多条图片，返回值是图片的rowId
         *
         * @param pictures
         * @return
         */
        LiveData<List<Long>> addPicToDb(Picture... pictures);
    }

    /**
     * 远程数据操作接口，包括网络,（ps：好像除了网络也没有其他了hhhh）
     */
    public interface RemoteDataSource {
        /**
         * 从网络获取指定条数图片数据
         *
         * @param count
         * @return
         */
        LiveData<Response<List<Picture>>> getPicFormNet(int count);
    }
}
