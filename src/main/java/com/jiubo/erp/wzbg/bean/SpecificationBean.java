package com.jiubo.erp.wzbg.bean;

import java.io.Serializable;

/**
 * @desc:办公用品规格
 * @date: 2019-07-10 13:06
 * @author: dx
 * @version: 1.0
 */
public class SpecificationBean implements Serializable{
    private static final long serialVersionUID = -7545625362725429261L;
    private String id;
    private String specification;
    private String nameId;

    public SpecificationBean() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    @Override
    public String toString() {
        return "SpecificationBean{" +
                "id='" + id + '\'' +
                ", specification='" + specification + '\'' +
                ", nameId='" + nameId + '\'' +
                '}';
    }
}
