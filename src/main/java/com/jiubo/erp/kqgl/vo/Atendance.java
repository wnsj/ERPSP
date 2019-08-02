package com.jiubo.erp.kqgl.vo;

public class Atendance {
    private String AtendanceId;
    private String name;
    private String earlyMinutes;
    private String laterMinutes;
    private String isValid;

    public Atendance() {
        // TODO Auto-generated constructor stub
    }

    public String getAtendanceId() {
        return AtendanceId;
    }

    public void setAtendanceId(String atendanceId) {
        AtendanceId = atendanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEarlyMinutes() {
        return earlyMinutes;
    }

    public void setEarlyMinutes(String earlyMinutes) {
        this.earlyMinutes = earlyMinutes;
    }

    public String getLaterMinutes() {
        return laterMinutes;
    }

    public void setLaterMinutes(String laterMinutes) {
        this.laterMinutes = laterMinutes;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }


}
