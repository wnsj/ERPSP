package com.jiubo.erp.wzbg.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.jiubo.erp.wzbg.service.DimissionApplyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dx
 * @since 2019-08-02
 */

@RestController
@RequestMapping("/dimissionApplyController")
public class DimissionApplyController {

    @Autowired
    private DimissionApplyService dimissionApplyService;

    /* *
     * @desc:离职管理查询
     * @author: dx
     * @date: 2019-08-03 15:05:12
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/dimissionApplyController/queryDimissionApply
    @PostMapping("/queryDimissionApply")
    public JSONObject queryDimissionApply(@RequestBody String params)throws Exception{
        if(StringUtils.isBlank(params))throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE,Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        DimissionApplyBean dimissionApplyBean = JSONObject.parseObject(params, DimissionApplyBean.class);
        jsonObject.put(Constant.Result.RETDATA,dimissionApplyService.queryDimissionApply(dimissionApplyBean));
        return jsonObject;
    }

    /* *
    * @desc:离职申请
    * @author: dx
    * @date: 2019-08-10 10:09:43
    * @param params :
    * @return: com.alibaba.fastjson.JSONObject
    * @throws:
    * @version: 1.0
    **/
    //http://127.0.0.1:8080/dimissionApplyController/addDimissionApply
    @PostMapping("/addDimissionApply")
    public JSONObject addDimissionApply(@RequestBody String params)throws Exception{
        if(StringUtils.isBlank(params))throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE,Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        DimissionApplyBean dimissionApplyBean = JSONObject.parseObject(params, DimissionApplyBean.class);
        dimissionApplyService.addDimissionApply(dimissionApplyBean);
        return jsonObject;
    }

    /* *
     * @desc:修改离职申请
     * @author: dx
     * @date: 2019-08-10 15:19:15
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/dimissionApplyController/addDimissionApply
    @PostMapping("/updateDimissionApply")
    public JSONObject updateDimissionApply(@RequestBody String params)throws Exception{
        if(StringUtils.isBlank(params))throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE,Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        DimissionApplyBean dimissionApplyBean = JSONObject.parseObject(params, DimissionApplyBean.class);
        dimissionApplyService.updateDimissionApply(dimissionApplyBean);
        return jsonObject;
    }

    /* *
     * @desc:离职申请审核
     * @author: dx
     * @date: 2019-08-10 15:19:33
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/dimissionApplyController/examineApprove
    @PostMapping("/examineApprove")
    public JSONObject examineApprove(@RequestBody String params)throws Exception{
         if(StringUtils.isBlank(params))throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE,Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        DimissionApplyBean dimissionApplyBean = JSONObject.parseObject(params, DimissionApplyBean.class);
        dimissionApplyService.examineApprove(dimissionApplyBean);
        return jsonObject;
    }
}
