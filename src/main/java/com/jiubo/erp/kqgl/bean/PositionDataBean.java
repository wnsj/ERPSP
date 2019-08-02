package com.jiubo.erp.kqgl.bean;

import java.io.Serializable;

public class PositionDataBean implements Serializable {
    private static final long serialVersionUID = 455919147520681059L;
    private String Position_ID;
    private String Position_Name;
    private String PositionType_ID;
    private String IsPoint;

    public String getPosition_ID() {
        return Position_ID;
    }

    public void setPosition_ID(String position_ID) {
        Position_ID = position_ID;
    }

    public String getPosition_Name() {
        return Position_Name;
    }

    public void setPosition_Name(String position_Name) {
        Position_Name = position_Name;
    }

    public String getPositionType_ID() {
        return PositionType_ID;
    }

    public void setPositionType_ID(String positionType_ID) {
        PositionType_ID = positionType_ID;
    }

    public String getIsPoint() {
        return IsPoint;
    }

    public void setIsPoint(String isPoint) {
        IsPoint = isPoint;
    }

    @Override
    public String toString() {
        return "PositionDataBean [Position_ID=" + Position_ID + ", Position_Name=" + Position_Name
                + ", PositionType_ID=" + PositionType_ID + ", IsPoint=" + IsPoint + "]";
    }

}
