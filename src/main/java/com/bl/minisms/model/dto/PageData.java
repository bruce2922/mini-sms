package com.bl.minisms.model.dto;

import java.io.Serializable;
import java.util.List;

public class PageData implements Serializable {

    private long totalCount;
    /**
     * max data display per page
     */
    private int pageSize;
    private int totalPage;
    private int pageIndex;
    private List dataList;

    public static int DEFAULT_PAGE_SIZE = 3;


    public PageData(List list, long totalCount, int currPage, int pageSize) {
        this.dataList = list;
        this.totalCount = totalCount;
        this.pageIndex = currPage;
        this.pageSize = pageSize;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }
}
