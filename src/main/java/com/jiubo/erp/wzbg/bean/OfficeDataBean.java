package com.jiubo.erp.wzbg.bean;

import java.io.Serializable;

/**
 * @desc:
 * @date: 2019-07-23 08:52
 * @author: dx
 * @version: 1.0
 */
public class OfficeDataBean implements Serializable{
    private static final long serialVersionUID = 3734610530634815750L;
    private String id;
    private String name;

    public OfficeDataBean() {
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
        return "OfficeDataBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
