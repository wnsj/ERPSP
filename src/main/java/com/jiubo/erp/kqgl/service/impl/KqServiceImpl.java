package com.jiubo.erp.kqgl.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiubo.erp.kqgl.bean.AttLeaveTypeBean;
import com.jiubo.erp.kqgl.bean.AttRuleTypeBean;
import com.jiubo.erp.kqgl.bean.AttShiftGroupBean;
import com.jiubo.erp.kqgl.bean.AttShiftScheduleBean;
import com.jiubo.erp.kqgl.bean.PersonalKQBean;
import com.jiubo.erp.kqgl.bean.PositionDataBean;
import com.jiubo.erp.kqgl.bean.PositionTypeBean;
import com.jiubo.erp.kqgl.dao.kqglDao;
import com.jiubo.erp.kqgl.service.KqService;
import com.jiubo.erp.kqgl.vo.AttParam;
import com.jiubo.erp.kqgl.vo.ClassTime;
import com.jiubo.erp.kqgl.vo.DepartKQ;
import com.jiubo.erp.kqgl.vo.KqInfoResult;
import com.jiubo.erp.kqgl.vo.PositionResultInfo;
import com.jiubo.erp.kqgl.vo.PunchRecord;
import com.jiubo.erp.kqgl.vo.ScheduleQueryResult;
import com.jiubo.erp.rygl.bean.DepartmentBean;

@Service
@Transactional
public class KqServiceImpl implements KqService {

    @Autowired
    private kqglDao dao;

    @Override
    public List<KqInfoResult> selectKqInfoList(AttParam ap) {
        List<KqInfoResult> kqInfoList = this.dao.selectKqInfoList(ap);
        return kqInfoList;
    }

    @Override
    public List<KqInfoResult> searchKqInfoList(AttParam ap) {
        List<KqInfoResult> kqInfoList = this.dao.searchKqInfoList(ap);
        return kqInfoList;
    }

    @Override
    public List<ClassTime> selectClassTimeList(ClassTime ct) {
        return this.dao.selectClassTimeList(ct);
    }

    @Override
    public List<DepartKQ> selectDepartKqInfoList() {
        // TODO Auto-generated method stub
        return this.dao.selectDepartKqInfoList();
    }

    @Override
    public List<DepartKQ> searchDepartKqInfoList(DepartKQ departKQ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PunchRecord> selectPunchRecordList(PunchRecord pRecord) {

        return dao.selectPunchRecordList(pRecord);
    }

    /* (non-Javadoc)
     * @see com.jiubo.erp.kqgl.service.KqService#kqTableInfoList(com.jiubo.erp.kqgl.bean.PersonalKQBean)
     */
    @Override
    public List<KqInfoResult> kqTableInfoList(AttParam ap) {
        // TODO Auto-generated method stub
        return this.dao.kqTableInfoList(ap);
    }

    /* (non-Javadoc)
     * @see com.jiubo.erp.kqgl.service.KqService#kqTableCountList(com.jiubo.erp.kqgl.vo.KqInfoResult)
     */
    @Override
    public List<KqInfoResult> kqTableCountList(AttParam ap) {
        // TODO Auto-generated method stub
        return this.dao.kqTableCountList(ap);
    }

    /* (non-Javadoc)
     * @see com.jiubo.erp.kqgl.service.KqService#selectKIGList(com.jiubo.erp.kqgl.vo.KqInfoResult)
     */
    @Override
    public List<KqInfoResult> selectKIGList(AttParam ap) {
        // TODO Auto-generated method stub
        return this.dao.selectKIGList(ap);
    }


}
