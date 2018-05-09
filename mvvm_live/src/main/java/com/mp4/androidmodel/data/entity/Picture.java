package com.mp4.androidmodel.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mopengfei on 2018-05-07.
 * {
 * "startdate": "20180508",
 * "fullstartdate": "201805081600",
 * "enddate": "20180509",
 * "url": "/az/hprichbg/rb/LongtailedWidowbird_ZH-CN7843068065_1920x1080.jpg",
 * "urlbase": "/az/hprichbg/rb/LongtailedWidowbird_ZH-CN7843068065",
 * "copyright": "利特弗雷自然保护区内的雄性长尾巧织雀，南非 (© Richard Du Toit/Getty Images)",
 * "copyrightlink": "http://www.bing.com/search?q=%E5%88%A9%E7%89%B9%E5%BC%97%E9%9B%B7%E8%87%AA%E7%84%B6%E4%BF%9D%E6%8A%A4%E5%8C%BA&form=hpcapt&mkt=zh-cn",
 * "quiz": "/search?q=Bing+homepage+quiz&filters=WQOskey:%22HPQuiz_20180508_LongtailedWidowbird%22&FORM=HPQUIZ",
 * "wp": true,
 * "hsh": "813bb0820dcfeb1fdabf0bb74bba1311",
 * "drk": 1,
 * "top": 1,
 * "bot": 1,
 * "hs": []
 * }
 */
@Entity(tableName = "tb_picture")//设置表名，不设置默认为类名
public final class Picture {
    @PrimaryKey(autoGenerate = true)//自动生成并自增，同autoincrement
    @ColumnInfo(name = "_id")//表中字段名，不设置默认为属性名
    private int id;//属性如设置为private则需要提供setter和getter，否则需要设置为public
    private String url;
    private String copyright;
    private String copyrightlink;
    @Ignore//忽略此属性，不作为表的字段名
    private String hsh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCopyrightlink() {
        return copyrightlink;
    }

    public void setCopyrightlink(String copyrightlink) {
        this.copyrightlink = copyrightlink;
    }

    public String getHsh() {
        return hsh;
    }

    public void setHsh(String hsh) {
        this.hsh = hsh;
    }
}
