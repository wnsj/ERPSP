package com.jiubo.erp.rygl.bean;

//项目表
public class ProjectDataBean {
    private String ProjectID;
    private String ProjectName;
    private String ProjectState;
    private String DataBaseName;
    private String ProjectNote;

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectState() {
        return ProjectState;
    }

    public void setProjectState(String projectState) {
        ProjectState = projectState;
    }

    public String getDataBaseName() {
        return DataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        DataBaseName = dataBaseName;
    }

    public String getProjectNote() {
        return ProjectNote;
    }

    public void setProjectNote(String projectNote) {
        ProjectNote = projectNote;
    }


}
