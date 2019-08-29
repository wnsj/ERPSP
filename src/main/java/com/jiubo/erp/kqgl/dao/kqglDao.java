package com.jiubo.erp.kqgl.dao;

import java.util.List;


import com.jiubo.erp.kqgl.bean.PersonalKQBean;
import com.jiubo.erp.kqgl.vo.AttParam;
import com.jiubo.erp.kqgl.vo.ClassTime;
import com.jiubo.erp.kqgl.vo.DepartKQ;
import com.jiubo.erp.kqgl.vo.KqInfoResult;
import com.jiubo.erp.kqgl.vo.PunchRecord;

public interface kqglDao {
    //公司考勤
    List<KqInfoResult> allEMPOfFirmKQList(AttParam ap);

    //部门考勤
    List<KqInfoResult> departOfFirmKQList(AttParam ap);

    //部门考勤---双击部门考勤
    List<KqInfoResult> singleDepartOfFirmKQList(AttParam ap);

    //人员考勤empkqList
    List<PersonalKQBean> empkqList(AttParam ap);

    //考勤统计报表
    List<PersonalKQBean> kqCountTable(AttParam ap);



    //加载考勤基础信息列表
    List<KqInfoResult> selectKqInfoList(AttParam ap);

    //搜索考勤信息列表
    List<KqInfoResult> searchKqInfoList(AttParam ap);

    //查询班次列表
    List<ClassTime> selectClassTimeList(ClassTime ct);

    //查询考勤信息
    List<PunchRecord> selectPunchRecordList(PunchRecord pRecord);

    //查询所有部门
    List<DepartKQ> selectDepartKqInfoList(AttParam ap);

    //搜索部门考勤
    List<DepartKQ> searchDepartKqInfoList(DepartKQ departKQ);

    //考勤报表
    List<KqInfoResult> kqTableInfoList(AttParam ap);

    //考勤报表统计
    List<KqInfoResult> kqTableCountList(AttParam ap);

    List<KqInfoResult> selectKIGList(AttParam ap);

}
