package com.jiubo.erp.kqgl.bean;

import com.jiubo.erp.rygl.bean.EmployeeBasicBean;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PositionDataBean implements Serializable {
    private static final long serialVersionUID = 455919147520681059L;
    private String Position_ID;
    private String Position_Name;
    private String PositionType_ID;
    private String IsPoint;
    private List<EmployeeBasicBean> employeeList;
}
