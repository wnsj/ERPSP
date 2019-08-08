package com.jiubo.erp.wzbg.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 离职管理bean
 * </p>
 *
 * @author dx
 * @since 2019-08-02
 */
@Data
@TableName("Dimission_Apply")
public class DimissionApplyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String daId;//申请人id

    private String daName;//申请人姓名

    private String daDepartmentId;//部门id

    private String daDepartmentName;//部门名

    private String daPositionId;//职位id

    private String daPositionName;//职位名

    private String daEntryTime;//入职日期

    private String daApplyTime;//申请日期

    private String daLeaveTime;//离职日期

    private String daResaon;//离职原因

    private String daChargeId;//主管id

    private String daChargeName;//主管姓名

    private String daChargeAdvice;//主管意见【null和1:未审核,2:同意,3:不同意】

    private String daChargeSee;

    private String daMinisterId;//审查人id

    private String daMinisterName;//审查人姓名

    private String daMinisterAdvice;//审查人意见【null和1:未审核,2:同意,3:不同意】

    private String daMinisterSee;

    private String daConnectId;//交接人id

    private String daConnectName;//交接人姓名

    private String daConnectAdvice;//交接人意见【null和1:未审核,2:同意,3:不同意】

    private String daConnectSee;

    private String daPersonnelOfficeId;//人资办交接人id

    private String daPersonnelOfficeName;//人资办交接人姓名

    private String daPersonnelOfficeAdvice;//人资办交接人意见【null和1:未审核,2:同意,3:不同意】

    private String daPersonnelOfficeSee;

    private String daAuditorId;

    private String daAuditorAdvice;

    private String daAuditorSee;

    private String daApproverId;

    private String daApproverAdvice;

    private String daApproverSee;

    private String daReportId;

    private String daReportAdvice;

    private String daReportSee;

    private String daOtherRemark;

    private String daSee;

    private String daType;//离职类型【1:辞职，2：辞退，3：其它】

    private String daMinisterRemark;//审查人备注

    private String daPersonnelOfficeSee1;

    private String daConnectSee1;

    private String daIsCollect;//是否完成【1：完成，null：未完成】

    private String daYes;

    private String begDate;

    private String endDate;

    private String dateType;

}
