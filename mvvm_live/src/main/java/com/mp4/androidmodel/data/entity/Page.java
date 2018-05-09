package com.mp4.androidmodel.data.entity;

import java.util.List;

/**
 * Created by mopengfei on 2018-05-07.
 * 分页获取类
 */

public class Page<T> {
    public static final int startPageNo = 1;//开始页为1
    public static int pageSize = 10;//默认一页十个
    private int pageNo;
    private List<T> data;
    private int totalSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public boolean hasMore() {
        return totalSize > pageNo * pageSize;
    }
}
