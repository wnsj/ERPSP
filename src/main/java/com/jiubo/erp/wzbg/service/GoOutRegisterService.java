package com.jiubo.erp.wzbg.service;

import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.GoOutRegisterBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dx
 * @since 2019-08-11
 */
public interface GoOutRegisterService extends IService<GoOutRegisterBean> {
    /* *
     * @desc:外出登记查询
     * @author: dx
     * @date: 2019-08-11 13:23:07
     * @param goOutRegisterBean :
     * @return: java.util.List<com.jiubo.erp.wzbg.bean.GoOutRegisterBean>
     * @throws:
     * @version: 1.0
     **/
    List<GoOutRegisterBean> queryGoOutRegister(GoOutRegisterBean goOutRegisterBean);

    /* *
     * @desc:添加外出登记
     * @author: dx
     * @date: 2019-08-13 08:55:18
     * @param goOutRegisterBean :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    void addGoOutRegister(GoOutRegisterBean goOutRegisterBean) throws MessageException;

    /* *
     * @desc:修改外出登记
     * @author: dx
     * @date: 2019-08-13 08:55:57
     * @param goOutRegisterBean :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    void updateGoOutRegister(GoOutRegisterBean goOutRegisterBean) throws MessageException;

    /* *
     * @desc:查询部门下的员工
     * @author: dx
     * @date: 2019-08-13 08:57:22
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    List<Map<String,Object>> getOutData(Map<String,Object> params)throws MessageException;

    /**
     * 根据部门id查询相关负责人
     * @param map
     * @return
     */
    List<Map<String,Object>> selectDeptLeaderById(Map<String,Object> map) throws MessageException;

    /**
     * 根据部门id查询上一级部门信息
     * @param deptid
     * @return
     */
    Map<String,Object> expandDeptLeaderById(String counts,String deptid);

    /**
     * 根据id修改是否取消状态
     * @param id
     */
    void updateGoOutDeleteById(String id);

    /**
     * 更新通知人或报备人意见
     * @param map
     */
    void updateAdvice(Map<String, String> map) throws MessageException;
}
