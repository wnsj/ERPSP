package com.jiubo.erp.task.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @desc:
 * @date: 2019-08-27 09:17
 * @author: dx
 * @version: 1.0
 */
public interface NoticeDao {

    //办公用品申请通知
    public List<String> getOffice(@Param("flag") int flag);

    //根据权限id查询用户
    public List<String> queryAccountIdByRule(String ruleId);

    //查询考勤ID
    public List<String> askOfLeave();

    //查询倒休
    public List<String> restDown();

    //外出登记需要通知的用户
    List<String> queryGoOutRegisterAccountIds();
}
