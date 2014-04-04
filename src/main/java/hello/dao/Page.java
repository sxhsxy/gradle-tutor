package hello.dao;

import java.util.ArrayList;

/**
 * Created by Xiaohu on 14-4-2.
 */
public class Page<T> {
    private int pageNo = 1;
    private int pageSize = 20;
    private long count = 0;
    private ArrayList<T> list = new ArrayList<T>();

    public Page() {
    }

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRecordCount() {
        return count;
    }

    public void setRecordCount(long recordCount) {
        this.count = recordCount;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
