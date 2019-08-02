package com.jiubo.erp.common;


import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result<T> {

    private String status;

    private List<T> Listdata;

    private Map<String, Object> mapdata = new HashMap<String, Object>();

    private String Message;

    private PageParam page;

    private long totalnfo; //总记录数

    private long totalPages; //总页数

    private JSONObject data;


    public JSONObject getData() {
        return data;
    }


    public void setData(JSONObject data) {
        this.data = data;
    }


    public long getTotalnfo() {
        return totalnfo;
    }


    public void setTotalnfo(long totalnfo) {
        this.totalnfo = totalnfo;
    }


    public long getTotalPages() {
        return totalPages;
    }


    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }


    public void setTotalnfo(int totalnfo) {
        this.totalnfo = totalnfo;
    }


    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public PageParam getPage() {
        return page;
    }

    public void setPage(PageParam page) {
        this.page = page;
    }

    public Map<String, Object> getMapdata() {
        return mapdata;
    }

    public void setMapdata(Map<String, Object> mapdata) {
        this.mapdata = mapdata;
    }

    public List<T> getListdata() {
        return Listdata;
    }

    public void setListdata(List<T> listdata) {
        Listdata = listdata;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
