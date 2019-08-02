package com.jiubo.erp.wzbg.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 离职管理bean
 * </p>
 *
 * @author dx
 * @since 2019-08-02
 */
@TableName("Dimission_Apply")
public class DimissionApplyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    private Integer daId;

    @TableField("DA_Department_ID")
    private Integer daDepartmentId;

    @TableField("DA_Position_ID")
    private Integer daPositionId;

    @TableField("DA_Entry_Time")
    private LocalDateTime daEntryTime;

    @TableField("DA_Apply_Time")
    private LocalDateTime daApplyTime;

    @TableField("DA_Leave_Time")
    private LocalDateTime daLeaveTime;

    @TableField("DA_Resaon")
    private String daResaon;

    @TableField("DA_Charge_ID")
    private Integer daChargeId;

    @TableField("DA_Charge_Advice")
    private Integer daChargeAdvice;

    @TableField("DA_Charge_See")
    private Integer daChargeSee;

    @TableField("DA_Minister_ID")
    private Integer daMinisterId;

    @TableField("DA_Minister_Advice")
    private Integer daMinisterAdvice;

    @TableField("DA_Minister_See")
    private Integer daMinisterSee;

    @TableField("DA_Connect_ID")
    private Integer daConnectId;

    @TableField("DA_Connect_Advice")
    private Integer daConnectAdvice;

    @TableField("DA_Connect_See")
    private Integer daConnectSee;

    @TableField("DA_Personnel_Office_ID")
    private Integer daPersonnelOfficeId;

    @TableField("DA_Personnel_Office_Advice")
    private Integer daPersonnelOfficeAdvice;

    @TableField("DA_Personnel_Office_See")
    private Integer daPersonnelOfficeSee;

    @TableField("DA_Auditor_ID")
    private Integer daAuditorId;

    @TableField("DA_Auditor_Advice")
    private Integer daAuditorAdvice;

    @TableField("DA_Auditor_See")
    private Integer daAuditorSee;

    @TableField("DA_Approver_ID")
    private Integer daApproverId;

    @TableField("DA_Approver_Advice")
    private Integer daApproverAdvice;

    @TableField("DA_Approver_See")
    private Integer daApproverSee;

    @TableField("DA_Report_ID")
    private Integer daReportId;

    @TableField("DA_Report_advice")
    private Integer daReportAdvice;

    @TableField("DA_Report_See")
    private Integer daReportSee;

    @TableField("DA_Other_Remark")
    private String daOtherRemark;

    @TableField("DA_See")
    private Integer daSee;

    @TableField("DA_Type")
    private Integer daType;

    @TableField("DA_Minister_Remark")
    private String daMinisterRemark;

    @TableField("DA_Personnel_Office_See1")
    private Integer daPersonnelOfficeSee1;

    @TableField("DA_Connect_See1")
    private Integer daConnectSee1;

    @TableField("DA_Is_Collect")
    private Integer daIsCollect;

    @TableField("DA_Yes")
    private Integer daYes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }
    public Integer getDaDepartmentId() {
        return daDepartmentId;
    }

    public void setDaDepartmentId(Integer daDepartmentId) {
        this.daDepartmentId = daDepartmentId;
    }
    public Integer getDaPositionId() {
        return daPositionId;
    }

    public void setDaPositionId(Integer daPositionId) {
        this.daPositionId = daPositionId;
    }
    public LocalDateTime getDaEntryTime() {
        return daEntryTime;
    }

    public void setDaEntryTime(LocalDateTime daEntryTime) {
        this.daEntryTime = daEntryTime;
    }
    public LocalDateTime getDaApplyTime() {
        return daApplyTime;
    }

    public void setDaApplyTime(LocalDateTime daApplyTime) {
        this.daApplyTime = daApplyTime;
    }
    public LocalDateTime getDaLeaveTime() {
        return daLeaveTime;
    }

    public void setDaLeaveTime(LocalDateTime daLeaveTime) {
        this.daLeaveTime = daLeaveTime;
    }
    public String getDaResaon() {
        return daResaon;
    }

    public void setDaResaon(String daResaon) {
        this.daResaon = daResaon;
    }
    public Integer getDaChargeId() {
        return daChargeId;
    }

    public void setDaChargeId(Integer daChargeId) {
        this.daChargeId = daChargeId;
    }
    public Integer getDaChargeAdvice() {
        return daChargeAdvice;
    }

    public void setDaChargeAdvice(Integer daChargeAdvice) {
        this.daChargeAdvice = daChargeAdvice;
    }
    public Integer getDaChargeSee() {
        return daChargeSee;
    }

    public void setDaChargeSee(Integer daChargeSee) {
        this.daChargeSee = daChargeSee;
    }
    public Integer getDaMinisterId() {
        return daMinisterId;
    }

    public void setDaMinisterId(Integer daMinisterId) {
        this.daMinisterId = daMinisterId;
    }
    public Integer getDaMinisterAdvice() {
        return daMinisterAdvice;
    }

    public void setDaMinisterAdvice(Integer daMinisterAdvice) {
        this.daMinisterAdvice = daMinisterAdvice;
    }
    public Integer getDaMinisterSee() {
        return daMinisterSee;
    }

    public void setDaMinisterSee(Integer daMinisterSee) {
        this.daMinisterSee = daMinisterSee;
    }
    public Integer getDaConnectId() {
        return daConnectId;
    }

    public void setDaConnectId(Integer daConnectId) {
        this.daConnectId = daConnectId;
    }
    public Integer getDaConnectAdvice() {
        return daConnectAdvice;
    }

    public void setDaConnectAdvice(Integer daConnectAdvice) {
        this.daConnectAdvice = daConnectAdvice;
    }
    public Integer getDaConnectSee() {
        return daConnectSee;
    }

    public void setDaConnectSee(Integer daConnectSee) {
        this.daConnectSee = daConnectSee;
    }
    public Integer getDaPersonnelOfficeId() {
        return daPersonnelOfficeId;
    }

    public void setDaPersonnelOfficeId(Integer daPersonnelOfficeId) {
        this.daPersonnelOfficeId = daPersonnelOfficeId;
    }
    public Integer getDaPersonnelOfficeAdvice() {
        return daPersonnelOfficeAdvice;
    }

    public void setDaPersonnelOfficeAdvice(Integer daPersonnelOfficeAdvice) {
        this.daPersonnelOfficeAdvice = daPersonnelOfficeAdvice;
    }
    public Integer getDaPersonnelOfficeSee() {
        return daPersonnelOfficeSee;
    }

    public void setDaPersonnelOfficeSee(Integer daPersonnelOfficeSee) {
        this.daPersonnelOfficeSee = daPersonnelOfficeSee;
    }
    public Integer getDaAuditorId() {
        return daAuditorId;
    }

    public void setDaAuditorId(Integer daAuditorId) {
        this.daAuditorId = daAuditorId;
    }
    public Integer getDaAuditorAdvice() {
        return daAuditorAdvice;
    }

    public void setDaAuditorAdvice(Integer daAuditorAdvice) {
        this.daAuditorAdvice = daAuditorAdvice;
    }
    public Integer getDaAuditorSee() {
        return daAuditorSee;
    }

    public void setDaAuditorSee(Integer daAuditorSee) {
        this.daAuditorSee = daAuditorSee;
    }
    public Integer getDaApproverId() {
        return daApproverId;
    }

    public void setDaApproverId(Integer daApproverId) {
        this.daApproverId = daApproverId;
    }
    public Integer getDaApproverAdvice() {
        return daApproverAdvice;
    }

    public void setDaApproverAdvice(Integer daApproverAdvice) {
        this.daApproverAdvice = daApproverAdvice;
    }
    public Integer getDaApproverSee() {
        return daApproverSee;
    }

    public void setDaApproverSee(Integer daApproverSee) {
        this.daApproverSee = daApproverSee;
    }
    public Integer getDaReportId() {
        return daReportId;
    }

    public void setDaReportId(Integer daReportId) {
        this.daReportId = daReportId;
    }
    public Integer getDaReportAdvice() {
        return daReportAdvice;
    }

    public void setDaReportAdvice(Integer daReportAdvice) {
        this.daReportAdvice = daReportAdvice;
    }
    public Integer getDaReportSee() {
        return daReportSee;
    }

    public void setDaReportSee(Integer daReportSee) {
        this.daReportSee = daReportSee;
    }
    public String getDaOtherRemark() {
        return daOtherRemark;
    }

    public void setDaOtherRemark(String daOtherRemark) {
        this.daOtherRemark = daOtherRemark;
    }
    public Integer getDaSee() {
        return daSee;
    }

    public void setDaSee(Integer daSee) {
        this.daSee = daSee;
    }
    public Integer getDaType() {
        return daType;
    }

    public void setDaType(Integer daType) {
        this.daType = daType;
    }
    public String getDaMinisterRemark() {
        return daMinisterRemark;
    }

    public void setDaMinisterRemark(String daMinisterRemark) {
        this.daMinisterRemark = daMinisterRemark;
    }
    public Integer getDaPersonnelOfficeSee1() {
        return daPersonnelOfficeSee1;
    }

    public void setDaPersonnelOfficeSee1(Integer daPersonnelOfficeSee1) {
        this.daPersonnelOfficeSee1 = daPersonnelOfficeSee1;
    }
    public Integer getDaConnectSee1() {
        return daConnectSee1;
    }

    public void setDaConnectSee1(Integer daConnectSee1) {
        this.daConnectSee1 = daConnectSee1;
    }
    public Integer getDaIsCollect() {
        return daIsCollect;
    }

    public void setDaIsCollect(Integer daIsCollect) {
        this.daIsCollect = daIsCollect;
    }
    public Integer getDaYes() {
        return daYes;
    }

    public void setDaYes(Integer daYes) {
        this.daYes = daYes;
    }

    @Override
    public String toString() {
        return "DimissionApplyBean{" +
            "id=" + id +
            ", daId=" + daId +
            ", daDepartmentId=" + daDepartmentId +
            ", daPositionId=" + daPositionId +
            ", daEntryTime=" + daEntryTime +
            ", daApplyTime=" + daApplyTime +
            ", daLeaveTime=" + daLeaveTime +
            ", daResaon=" + daResaon +
            ", daChargeId=" + daChargeId +
            ", daChargeAdvice=" + daChargeAdvice +
            ", daChargeSee=" + daChargeSee +
            ", daMinisterId=" + daMinisterId +
            ", daMinisterAdvice=" + daMinisterAdvice +
            ", daMinisterSee=" + daMinisterSee +
            ", daConnectId=" + daConnectId +
            ", daConnectAdvice=" + daConnectAdvice +
            ", daConnectSee=" + daConnectSee +
            ", daPersonnelOfficeId=" + daPersonnelOfficeId +
            ", daPersonnelOfficeAdvice=" + daPersonnelOfficeAdvice +
            ", daPersonnelOfficeSee=" + daPersonnelOfficeSee +
            ", daAuditorId=" + daAuditorId +
            ", daAuditorAdvice=" + daAuditorAdvice +
            ", daAuditorSee=" + daAuditorSee +
            ", daApproverId=" + daApproverId +
            ", daApproverAdvice=" + daApproverAdvice +
            ", daApproverSee=" + daApproverSee +
            ", daReportId=" + daReportId +
            ", daReportAdvice=" + daReportAdvice +
            ", daReportSee=" + daReportSee +
            ", daOtherRemark=" + daOtherRemark +
            ", daSee=" + daSee +
            ", daType=" + daType +
            ", daMinisterRemark=" + daMinisterRemark +
            ", daPersonnelOfficeSee1=" + daPersonnelOfficeSee1 +
            ", daConnectSee1=" + daConnectSee1 +
            ", daIsCollect=" + daIsCollect +
            ", daYes=" + daYes +
        "}";
    }
}
