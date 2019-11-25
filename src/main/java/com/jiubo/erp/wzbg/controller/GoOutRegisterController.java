package com.jiubo.erp.wzbg.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.wzbg.bean.GoOutRegisterBean;
import com.jiubo.erp.wzbg.service.GoOutRegisterService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dx
 * @since 2019-08-11
 */
@RestController
@RequestMapping("/goOutRegisterController")
public class GoOutRegisterController {

    @Autowired
    private GoOutRegisterService goOutRegisterService;

    /* *
     * @desc:外出登记查询
     * @author: dx
     * @date: 2019-08-11 13:23:49
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/goOutRegisterController/queryGoOutRegister
    @PostMapping("/queryGoOutRegister")
    public JSONObject queryGoOutRegister(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        GoOutRegisterBean goOutRegisterBean = JSONObject.parseObject(params, GoOutRegisterBean.class);
        jsonObject.put(Constant.Result.RETDATA, goOutRegisterService.queryGoOutRegister(goOutRegisterBean));
        return jsonObject;
    }

    /* *
     * @desc:外出登记
     * @author: dx
     * @date: 2019-08-12 11:22:17
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/goOutRegisterController/addGoOutRegister
    @PostMapping("/addGoOutRegister")
    public JSONObject addGoOutRegister(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        GoOutRegisterBean goOutRegisterBean = JSONObject.parseObject(params, GoOutRegisterBean.class);
        goOutRegisterService.addGoOutRegister(goOutRegisterBean);
        return jsonObject;
    }

    /* *
     * @desc:修改外出登记
     * @author: dx
     * @date: 2019-08-12 13:41:37
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/goOutRegisterController/updateGoOutRegister
    @PostMapping("/updateGoOutRegister")
    public JSONObject updateGoOutRegister(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        GoOutRegisterBean goOutRegisterBean = JSONObject.parseObject(params, GoOutRegisterBean.class);
        goOutRegisterService.updateGoOutRegister(goOutRegisterBean);
        return jsonObject;
    }

    /* *
     * @desc:查询部门下的员工
     * @author: dx
     * @date: 2019-08-13 09:15:03
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    //http://127.0.0.1:8080/goOutRegisterController/getOutData?deptId=54
    @PostMapping("/getOutData")
    public JSONObject getOutData(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> param = JSONObject.parseObject(params, Map.class);
        jsonObject.put(Constant.Result.RETDATA, goOutRegisterService.getOutData(param));
        return jsonObject;
    }


    /**
     * 根据部门id查询相关负责人（通知负责人）
     *
     * @param params {
     *               deptids:[]
     *               }
     * @return jsonObject
     * @throws Exception
     */
    @PostMapping("/selectDeptLeaderById")
    public JSONObject selectDeptLeaderById(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> map = JSON.parseObject(params, Map.class);
        jsonObject.put(Constant.Result.RETDATA, goOutRegisterService.selectDeptLeaderById(map));
        return jsonObject;
    }


    /**
     * 根据部门id查询上一级部门信息
     * @return
     * @throws Exception
     */
    @PostMapping("/expandDeptLeaderById")
    public JSONObject expandDeptLeaderById(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, Object> map = JSON.parseObject(params, Map.class);
        jsonObject.put(Constant.Result.RETDATA, goOutRegisterService.expandDeptLeaderById(map.get("counts").toString(),map.get("deptid").toString()));
        return jsonObject;
    }


    /**
     * 根据id修改是否取消状态
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/updateGoOutDeleteById")
    public JSONObject updateGoOutDeleteById(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, String> map = JSON.parseObject(params, Map.class);
        goOutRegisterService.updateGoOutDeleteById(map.get("id"));
        return jsonObject;
    }

    /**
     * 更新通知人或报备人意见
     * @param params
     * @return
     * @throws Exception
     */
    @PostMapping("/updateAdvice")
    public JSONObject updateAdvice(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        Map<String, String> map = JSON.parseObject(params, Map.class);
        goOutRegisterService.updateAdvice(map);
        return jsonObject;
    }
}
