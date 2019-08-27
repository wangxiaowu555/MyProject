package com.yingside.util;

import java.util.List;

public class PageBean<T> {
    private int code;
    private String msg;
    private int count;
    private List<T> data;
    private int pageNo;
    private int pageSize;

    public PageBean() {
    }

    public PageBean(int count, List<T> data, int pageNo, int pageSize) {
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = data;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageBean(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
