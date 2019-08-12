package com.jiubo.erp.kqgl.service;

import java.util.List;


import com.jiubo.erp.kqgl.vo.AttParam;
import com.jiubo.erp.kqgl.vo.ClassTime;
import com.jiubo.erp.kqgl.vo.DepartKQ;
import com.jiubo.erp.kqgl.vo.KqInfoResult;

import com.jiubo.erp.kqgl.vo.PunchRecord;

public interface KqService {
    //查询考勤人员基础信息列表
    List<KqInfoResult> selectKqInfoList(AttParam ap);

    //公司考勤
    public List<KqInfoResult> allEMPOfFirmKQList(AttParam ap);

    //查询考勤人员班次信息列表
    List<KqInfoResult> searchKqInfoList(AttParam ap);

    //查询个人班次列表
    List<ClassTime> selectClassTimeList(ClassTime ct);

    //查询打卡信息
    List<PunchRecord> selectPunchRecordList(PunchRecord pRecord);

    //查询部门列表
    List<DepartKQ> selectDepartKqInfoList(AttParam ap);

    //搜索部门考勤
    List<DepartKQ> searchDepartKqInfoList(DepartKQ departKQ);

    //考勤报表
    List<KqInfoResult> kqTableInfoList(AttParam ap);

    //考勤报表统计
    List<KqInfoResult> kqTableCountList(AttParam ap);

    //考勤人员        基础信息列表      按组
    List<KqInfoResult> selectKIGList(AttParam ap);
}
