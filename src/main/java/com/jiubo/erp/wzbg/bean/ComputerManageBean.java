package com.jiubo.erp.wzbg.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 电脑用品管理bean
 * </p>
 *
 * @author dx
 * @since 2019-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Computer")
public class ComputerManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    //部门id
    @TableField("DepartmentID")
    private String DepartmentID;

    //部门名
    private String DepartmentName;

    //提报时间
    @TableField("Start_time")
    private String startTime;

    //完成时间
    @TableField("End_time")
    private String endTime;

    //申请人姓名
    @TableField("Apply_name")
    private String applyName;

    //使用人ID
    @TableField("User_ID")
    private String userId;

    //使用人姓名
    @TableField("User_name")
    private String userName;

    //用品名称
    @TableField("Articles_name")
    private String articlesName;

    //主管ID
    @TableField("Zhu_ID")
    private String zhuId;

    private String zhuName;

    //对接人ID
    @TableField("Prepare_ID")
    private String prepareId;

    //岗位ID
    @TableField("Job_ID")
    private String jobId;

    //岗位名
    private String positionName;

    //主管意见
    @TableField("Zhu_Advice")
    private String zhuAdvice;

    //负责人意见
    @TableField("Fu_Advice")
    private String fuAdvice;

    //用品类型【0：领用电脑，1：更换配件，2：添加配件】
    @TableField("Type_ID")
    private String typeId;

    //申请人是否查看
    @TableField("Apply_see")
    private String applySee;

    //在主管是否查看
    @TableField("Zhu_see")
    private String zhuSee;

    //负责人是否查看
    @TableField("Fu_see")
    private String fuSee;

    //对接人是否查看
    @TableField("Dui_see")
    private String duiSee;

    //使用人是否查看
    @TableField("User_see")
    private String userSee;

    //申请人ID
    @TableField("Apply_ID")
    private String applyId;

    //负责人ID
    @TableField("Fu_ID")
    private String fuId;

    //负责人名字
    private String fuName;

    //是否是预申请【0:不是 ，1：是】
    //【2:预申请，0:普通】
    @TableField("Is_Reserve")
    private String isReserve;

    //预申请要求使用电脑时间
    private String renshiTime;

    //预申请对接时间
    private String prepareTime;

    //对接人姓名
    @TableField("Prepare_name")
    private String prepareName;

    //负责人的说明
    @TableField("Shuoming")
    private String Shuoming;

    //指定接单人ID
    @TableField("Pei_Jiedan_ID")
    private String peiJiedanId;

    //指定接单人是否查看【null：未     1：查看】
    @TableField("Pei_Jiedan_ID_see")
    private String peiJiedanIdSee;

    //是不是指配的单子【null：不是     1：是】
    @TableField("Is_Pei")
    private String isPei;

    //本单是否进行【null：未进行 1：进行中  2：已完成】
    @TableField("Is_Ing")
    private String isIng;

    private String begDate;

    private String endDate;

    //时间类型【0:提报时间，2：完成时间】
    private String dateType;

    //用户id
    private String accountId;

    //用户名
    private String accountName;

    //审核人意见类型【null:全部，1：同意，2：不同意，3：未审核】
    private String adviceType;
}
