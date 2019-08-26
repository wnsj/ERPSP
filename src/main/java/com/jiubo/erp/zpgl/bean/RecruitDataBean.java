package com.jiubo.erp.zpgl.bean;

import lombok.Data;

import java.io.Serializable;

//面试信息
@Data
public class RecruitDataBean implements Serializable {

    private static final long serialVersionUID = -7097531221123039163L;

    private String id;//id
    private String name;//姓名
    private String sex;//性别
    private String birth;//生日
    private String idNum; //身份证
    private String phone;//手机
    private String mail; //邮箱
    private String qq;//qq
    private String address; //现在地址
    private String homeAddress;//家庭地址
    private String homeTown;//籍贯
    private String accountProp;//户口性质
    private String ploitical;//政治面貌（political）
    private String marital;//婚姻
    private String nationality;//民族
    private String height;//身高
    private String weight;//体重
    private String bloodType;//血型
    private String education;//学历
    private String school;//毕业院校
    private String graduation;//毕业时间
    private String profession;//专业
    private String atSchool;//是否在校
    private String workCompany;//工作单位
    private String workexp;//相关经验
    private String certificate;//技能证书
    private String channel;//应聘渠道
    private String position;//职位
    private String department;//部门
    private String wages;//期望薪资
    private String interviewer;//面试官
    private String recruitDate;//面试时间
    private String invitationDate;//邀约时间
    private String score;//成绩
    private String isQualified;//是否合格
    private String isPay;//报销路费
    private String remark;//备注
    private String isEntry;//是否入职（0：未入职 1：在职 2：离职）
    private String isDelete;//是否有效（ 0：有效，1：失效）
    private String updateDate;//更新时间
    private String updateAccount;

    private String dateFlag;//面试管理时间查询（标记字段）
    private String begDate;//面试管理时间查询（开始时间）
    private String endDate;//结束时间

    private String channelName;
    private String departmentName;
    private String positionName;
}
