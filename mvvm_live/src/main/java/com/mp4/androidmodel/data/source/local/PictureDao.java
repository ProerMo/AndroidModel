package com.mp4.androidmodel.data.source.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mp4.androidmodel.data.entity.Picture;

import java.util.List;

/**
 * Created by mopengfei on 2018-05-09.
 * 数据库tb_picture{@link Picture}操作定义，增删查改
 */
@Dao //将此接口定义为操作数据库最直接的接口
public interface PictureDao {
    /**
     * 将多个或单个图片对象插入数据库中，返回值是插入的条数。
     * Insert (onConflict = OnConflictStrategy.REPLACE)//表明是插入操作，处理事务冲突的方式为REPLACE，
     * 有关sqlite的事务冲突的处理方式见 https://sqlite.org/lang_conflict.html
     *
     * @param pictures
     * @return
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertPicturesIntoDb(Picture... pictures);

    /**
     * 根据单个Id删除数据库中的图片对象，返回值是成功删除的条数。
     * Query表示要执行自定义的语句  TODO 最后的:id表示引用参数id，思考:若参数为string是否会导致SQL注入漏洞？ 05-09 20:38
     *
     * @param id
     * @return
     */
    @Query("DELETE from tb_picture where _id = :id")
    int deletePictureFromDbById(int id);

    /**
     * 根据单个或多个{@link Picture}对象进行删除操作，返回值是删除的条数。
     *
     * @param pictures
     * @return
     */
    @Delete()
    int deletePicturesFromDb(Picture... pictures);

    /**
     * 从数据库中删除所有{@link Picture}，返回值是删除的条数。
     *
     * @return
     */
    @Query("delete from tb_picture")
    int deleteAllPicFromDb();

    /**
     * 查询数据库中所有的{@link Picture} 对象
     *
     * @return
     */
    @Query("select * from tb_picture")
    LiveData<List<Picture>> selectAllPictureFromDb();

    /**
     * 根据Id查询{@link Picture}
     *
     * @param id
     * @return
     */
    @Query("select * from tb_picture where _id = :id")
    LiveData<Picture> selectPictureFromDbById(int id);

    /**
     * 根据传入的单个或多个{@link Picture}并匹配其主键修改数据库中对应的值
     *
     * @param pictures
     * @return
     */
    @Update
    int updatePictureFromDb(Picture... pictures);

    /**
     * 根据Id更新{@link Picture}中的备注。
     *
     * @param id
     * @param remark
     * @return
     */
    @Query("update tb_picture set remark = :remark where _id = :id")
    int updatePictureRemark(int id, String remark);
}
