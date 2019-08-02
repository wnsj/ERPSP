package com.jiubo.erp.wzbg.bean;

import java.io.Serializable;

/**
 * @desc:办公用品名
 * @date: 2019-07-10 13:04
 * @author: dx
 * @version: 1.0
 */
public class OfficeNameBean implements Serializable{
    private static final long serialVersionUID = -2196209571536020832L;
    private String id;
    private String name;

    public OfficeNameBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OfficeNameBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
