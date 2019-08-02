package com.jiubo.erp.zpgl.bean;

import java.io.Serializable;

//招聘渠道
public class RecruitChannelBean implements Serializable {

    private static final long serialVersionUID = -944158054506370982L;

    private String recruitChannelId;//招聘渠道id

    private String recruitChannelName;//招聘渠道名

    public RecruitChannelBean() {
        super();
    }

    public String getRecruitChannelId() {
        return recruitChannelId;
    }

    public void setRecruitChannelId(String recruitChannelId) {
        this.recruitChannelId = recruitChannelId;
    }

    public String getRecruitChannelName() {
        return recruitChannelName;
    }

    public void setRecruitChannelName(String recruitChannelName) {
        this.recruitChannelName = recruitChannelName;
    }

    @Override
    public String toString() {
        return "RecruitChannelBean [recruitChannelId=" + recruitChannelId + ", recruitChannelName=" + recruitChannelName
                + "]";
    }
}
