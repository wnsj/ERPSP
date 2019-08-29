package com.jiubo.erp.wzbg.service;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.OfficeSuppliesDataBean;
import com.jiubo.erp.wzbg.bean.OfficeUserDataBean;
import com.jiubo.erp.wzbg.bean.OfficeDataBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @date: 2019-07-12 15:22
 * @author: dx
 * @version: 1.0
 */
public interface OfficeService {

    /* *
     * @desc:
     * @author: dx
     * @date: 2019-07-09 09:27:09
     * @param requestMap :
     * @return: java.util.List<com.jiubo.erp.wzbg.bean.OfficeSuppliesDataBean>
     * @throws:
     * @version: 1.0
     **/
    public List<OfficeSuppliesDataBean> queryOfficeSuppliesData(OfficeSuppliesDataBean officeSuppliesDataBean) throws MessageException;

    /* *
     * @desc:所有办公用品及规格
     * @author: dx
     * @date: 2019-07-12 09:30:52
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryOfficeNames() throws MessageException;

    /* *
     * @desc:新增，修改办公用品
     * @author: dx
     * @date: 2019-07-12 17:54:34
     * @param params :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void addUpdateOfficeSupplies(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:判断当月是否已经汇总（已经汇总返回9999，没有返回0000）
     * @author: dx
     * @date: 2019-07-16 10:01:54
     * @param params :
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @throws:
     * @version: 1.0
     **/
    public Map<String, Object> isHuiZong(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:审核接口
     * @author: dx
     * @date: 2019-07-15 16:36:30
     * @param params :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void shenHeOfficeSupplies(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:办公用品汇总
     * @author: dx
     * @date: 2019-07-17 09:47:14
     * @param params :
     * @return: java.util.List<com.jiubo.erp.wzbg.bean.OfficeSuppliesDataBean>
     * @throws:
     * @version: 1.0
     **/
    public Map<String, Object> gatherOfficeSupplies(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:获取意见给出人
     * @author: dx
     * @date: 2019-07-17 10:15:34
     * @param params :
     * 参数最外层为一个json对象，里面为一个json数组（均为固定key）
     * 例：{params:[{deptName:"总经办",postName:"副总经理",key:"自定义返回key"}]}
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @throws:
     * @version: 1.0
     **/
    public Map<String, Object> queryAdvancePeo(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询审核意见
     * @author: dx
     * @date: 2019-07-17 13:59:20
     * @param params :
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @throws:
     * @version: 1.0
     **/
    public Map<String, Object> queryAdvance(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:提交，审核
     * @author: dx
     * @date: 2019-07-17 16:33:34
     * @param params :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void commitAndSheHe(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:
     * @author: dx
     * @date: 2019-07-18 09:59:45
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryDeptConscientious(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询本部门主管
     * @author: dx
     * @date: 2019-08-06 10:18:41
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryDeptResponsible(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:扩大主管范围
     * @author: dx
     * @date: 2019-08-06 11:01:04
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryDeptExpandResponsible(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询审查人
     * @author: dx
     * @date: 2019-08-06 11:23:57
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryCensor(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询电脑交接人
     * @author: dx
     * @date: 2019-08-09 09:55:09
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryComputerHandover(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询生活用品交接人
     * @author: dx
     * @date: 2019-08-09 09:55:09
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryOfficeHandover(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询人力负责人
     * @author: dx
     * @date: 2019-08-09 09:55:09
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryManpowerOfficer(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:查询审批负责人
     * @author: dx
     * @date: 2019-08-09 09:55:09
     * @param params :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String, Object>> queryApprovalOfficer(Map<String, Object> params) throws MessageException;

    /* *
     * @desc:会议室申请信息查询
     * @author: dx
     * @date: 2019-07-23 09:36:14
     * @param officeUserDataBean :
     * @return: java.util.List<com.jiubo.erp.wzbg.bean.OfficeUserDataBean>
     * @throws:
     * @version: 1.0
     **/
    public List<OfficeUserDataBean> queryOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException;

    /* *
     * @desc:会议室申请
     * @author: dx
     * @date: 2019-07-26 08:21:30
     * @param officeUserDataBean :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void addOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException;

    public void updateOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException;

    /* *
    * @desc:会议室查询
    * @author: dx
    * @date: 2019-07-23 09:01:50
    * @return: java.util.List<com.jiubo.erp.zpgl.bean.OfficeDataBean>
    * @throws:
    * @version: 1.0
    **/
    public List<OfficeDataBean> queryOfficeData() throws MessageException;

    /* *
     * @desc:会议预约信息添加及修改
     * @author: dx
     * @date: 2019-07-30 08:34:37
     * @param officeUserDataBean :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void addUpdateOfficeUserData(OfficeUserDataBean officeUserDataBean) throws MessageException;

    /* *
     * @desc:修改会议室预约信息状态
     * @author: dx
     * @date: 2019-07-30 09:12:41
     * @param officeUserDataBean :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void updateOfficeUserDataState(OfficeUserDataBean officeUserDataBean) throws MessageException;

    /* *
     * @desc:查询通知人
     * @author: dx
     * @date: 2019-08-28 09:21:18
     * @param jsonObject :
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @throws:
     * @version: 1.0
     **/
    public List<Map<String,Object>> queryNotice(JSONObject jsonObject)throws MessageException;

    /* *
     * @desc:修改各领导办公用品申请信息查看情况
     * @author: dx
     * @date: 2019-08-28 09:22:27
     * @param officeUserDataBean :
     * @return: void
     * @throws:
     * @version: 1.0
     **/
    public void updateOfficeSuppliesSee(OfficeSuppliesDataBean officeSuppliesDataBean) throws MessageException;
}
