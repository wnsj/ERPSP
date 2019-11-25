package com.jiubo.erp.wzbg.bean;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author dx
 * @since 2019-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Go_Out_Register")
public class GoOutRegisterBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    //申请人id
    @TableField("Go_Out_Apply_ID")
    private String goOutApplyId;

    //申请人姓名
    private String goOutApplyName;

    //外出人姓名
    @TableField("Go_Out_Name")
    private String goOutName;

    //填表时间（申请时间）
    @TableField("Go_Out_Apply_Time")
    private String goOutApplyTime;

    //归岗时间
    @TableField("Go_Out_Come_Time")
    private String goOutComeTime;

    //外出时间
    @TableField("Go_Out_Go_Time")
    private String goOutGoTime;

    //当天是否归岗【1：是，2：否】
    @TableField("Go_Out_Type")
    private String goOutType;

    //目的地
    @TableField("Go_Out_Address")
    private String goOutAddress;

    //外出原因
    @TableField("Go_Out_Region")
    private String goOutRegion;

    //部门id
    @TableField("Go_Out_Department_ID")
    private String goOutDepartmentId;

    //部门名
    private String goOutDepartmentName;

    @TableField("Go_Out_Inform_ID")
    private String goOutInformId;

    @TableField("Go_Out_Sum")
    private String goOutSum;

    @TableField("Go_Out_Sum_Type")
    private String goOutSumType;

    //是否取消【null：未取消，1：已取消】
    @TableField("Go_Out_Delete")
    private String goOutDelete;

    //通知人id
    @TableField("Go_Out_Tongzhi_ID")
    private String goOutTongzhiId;

    //通知人姓名
    private String goOutTongzhiName;

    @TableField("Go_Out_Tongzhi_Advice")
    private String goOutTongzhiAdvice;

    @TableField("Go_Out_Is_See")
    private String goOutIsSee;

    //外出类型【1：班中外出，2:班前外出】
    @TableField("Go_Out_OtherType")
    private String goOutOthertype;

    @TableField("Go_Report_ID")
    private String goReportId;

    private String goReportName;

    @TableField("Go_Report_See")
    private String goReportSee;

    @TableField("Go_Report_Advice")
    private String goReportAdvice;

    private String begDate;

    private String endDate;

    //全部意见
    private String allAdvice;

    private JSONArray gotOutDateArr;//外出时间数组

    private JSONArray goOutNameArr;//外出人员姓名数组
}




