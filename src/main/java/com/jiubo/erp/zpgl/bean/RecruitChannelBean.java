package com.jiubo.erp.zpgl.bean;

import lombok.Data;

import java.io.Serializable;

//招聘渠道
@Data
public class RecruitChannelBean implements Serializable {

    private static final long serialVersionUID = -944158054506370982L;

    private String recruitChannelId;//招聘渠道id
    private String recruitChannelName;//招聘渠道名
}
