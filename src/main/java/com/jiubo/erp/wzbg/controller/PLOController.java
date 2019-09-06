package com.jiubo.erp.wzbg.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.common.Constant;
import com.jiubo.erp.common.ExcelUtil;
import com.jiubo.erp.common.MapUtil;
import com.jiubo.erp.common.MessageException;
import com.jiubo.erp.rygl.controller.EmpController;
import com.jiubo.erp.wzbg.service.PLOService;
import com.jiubo.erp.wzbg.vo.PLOParam;
import com.quicksand.push.ToolClass;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * @author mwl
 */
@RestController
@RequestMapping("/wzbg")
public class PLOController {

    public static Logger log = LoggerFactory.getLogger(EmpController.class);
    @Autowired
    private PLOService service;

    /**
     * 请假-列表
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月3日 下午2:35:25
     */

    @ResponseBody
    @RequestMapping(value = "/askOfLeaveList")
    public JSONObject askOfLeaveList(HttpServletResponse response, HttpServletRequest request) {
        return this.service.askOfLeaveList(response, request);
    }

    /**
     * 请假申请
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午9:43:42
     */
    @ResponseBody
    @RequestMapping(value = "/insertLeaveApplication")
    public JSONObject insertLeaveApplication(HttpServletResponse response, HttpServletRequest request) {

        return this.service.insertLeaveApplication(response, request);
    }

    /**
     * 请假修改 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月22日 上午9:38:51
     */
    @ResponseBody
    @RequestMapping(value = "/updateLeaveApplication")
    public JSONObject updateLeaveApplication(HttpServletResponse response, HttpServletRequest request) {

        return this.service.updateLeaveApplication(response, request);
    }

    /**
     * 请假 -- 代理人员列表
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月3日 下午2:37:15
     */
    @ResponseBody
    @RequestMapping(value = "/departOfEmpList")
    public JSONObject selectDepartOfEmpList(HttpServletResponse response, HttpServletRequest request) {

        return this.service.selectDepartOfEmpList(response, request);
    }

    /**
     * 请假审查 -- 审查人列表 根据请假人的级别查看审查列表
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午10:20:08
     */
    @ResponseBody
    @RequestMapping(value = "/checkOfEmpList")
    public JSONObject checkOfEmpList(HttpServletResponse response, HttpServletRequest request) {

        return this.service.checkOfEmpList(response, request);
    }


    /**
     * 请假审核 -- 审查人列表 根据请假人的级别查看审查列表
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午10:20:08
     */
    @ResponseBody
    @RequestMapping(value = "/verifyOfEmpList")
    public JSONObject verifyOfEmpList(HttpServletResponse response, HttpServletRequest request) {

        PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            result.put("resData", this.service.verifyOfEmpList(plop));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }


    /**
     * 请假审批 -- 审查人列表 根据请假人的级别查看审查列表
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午10:20:08
     */
    @ResponseBody
    @RequestMapping(value = "/approveOfEmpList")
    public JSONObject approveOfEmpList(HttpServletResponse response, HttpServletRequest request) {

        PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("plop:" + plop.toString());
            result.put("resData", this.service.approveOfEmpList(plop));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 倒休 列表
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午9:45:48
     */
    @ResponseBody
    @RequestMapping(value = "/restDownList")
    public JSONObject restDownList(HttpServletResponse response, HttpServletRequest request) {

        return this.service.restDownList(response, request);
    }


    /**
     * 倒休 申请
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午9:45:48
     */
    @ResponseBody
    @RequestMapping(value = "/restDownApply")
    public JSONObject restDownApply(HttpServletResponse response, HttpServletRequest request) {

        return this.service.restDownApply(response, request);
    }


    /**
     * 倒休 修改
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年7月8日 上午9:45:48
     */
    @ResponseBody
    @RequestMapping(value = "/updateRestDown")
    public JSONObject updateRestDown(HttpServletResponse response, HttpServletRequest request) {

        return this.service.restDownModify(response, request);
    }

    /**
     * 人员需求列表
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:42:27
     */
    @ResponseBody
    @RequestMapping(value = "/empRequireLsit")
    public JSONObject selectEmpRequireLsit(HttpServletResponse response, HttpServletRequest request) {

        return this.service.selectEmpRequireLsit(response, request);
    }

    ;

    /**
     * 人员需求申请
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:42:27
     */
    @ResponseBody
    @RequestMapping(value = "/insertEmpRequireApply")
    public JSONObject insertEmpRequireApply(HttpServletResponse response, HttpServletRequest request) {

        return this.service.insertEmpRequireApply(response, request);
    }

    ;

    /**
     * 修改人员需求
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:01
     */
    @ResponseBody
    @RequestMapping(value = "/updateRYRequire")
    public JSONObject updateRYRequire(HttpServletResponse response, HttpServletRequest request) {

        return this.service.updateRYRequire(response, request);
    }

    /**
     * 工作年限
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:30
     */
    @ResponseBody
    @RequestMapping(value = "/selectWorkAge")
    public JSONObject selectWorkAge(HttpServletResponse response, HttpServletRequest request) {
        return this.service.selectWorkAge(response, request);
    }

    /**
     * 专业
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:43:54
     */
    @ResponseBody
    @RequestMapping(value = "/selectMajor")
    public JSONObject selectMajor(HttpServletResponse response, HttpServletRequest request) {
        return this.service.selectMajor(response, request);
    }

    /**
     * 跳槽频率
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:44:21
     */
    @ResponseBody
    @RequestMapping(value = "/jobHopFrequency")
    public JSONObject selectJobHopFrequency(HttpServletResponse response, HttpServletRequest request) {
        return this.service.selectJobHopFrequency(response, request);
    }

    /**
     * 行业
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:45:25
     */
    @ResponseBody
    @RequestMapping(value = "/industryBackground")
    public JSONObject selectIndustryBackground(HttpServletResponse response, HttpServletRequest request) {
        return this.service.selectIndustryBackground(response, request);
    }

    /**
     * 年龄段列表
     * 方法说明
     *
     * @param response
     * @param request
     * @return JSONObject
     * @author 作者 : mwl
     * @version 创建时间：2019年8月1日 下午1:45:58
     */
    @ResponseBody
    @RequestMapping(value = "/selectAgeLsit")
    public JSONObject selectAgeLsit(HttpServletResponse response, HttpServletRequest request) {

        return this.service.selectAgeLsit(response, request);
    }


    /**
     * 人员需求审查人列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/empRequireCheckList")
    public JSONObject empRequireCheckList(HttpServletResponse response, HttpServletRequest request) {

        PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("plop:" + plop.toString());
            result.put("resData", this.service.checkEMPRequire(plop));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 人员需求审批人列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/empRequireVerifyList")
    public JSONObject empRequireVerifyList(HttpServletResponse response, HttpServletRequest request) {

        PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("plop:" + plop.toString());
            result.put("resData", this.service.verifyEMPRequire(plop));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }

    /**
     * 人员需求审批人列表
     *
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/empRequireApprovalList")
    public JSONObject empRequireApprovalList(HttpServletResponse response, HttpServletRequest request) {

        PLOParam plop = new PLOParam();
        JSONObject result = new JSONObject();
        String retCode = Constant.Result.SUCCESS;
        String retMsg = Constant.Result.SUCCESS_MSG;
        try {
            String str = ToolClass.getStrFromInputStream(request);
            if (StringUtils.isBlank(str))
                throw new MessageException("参数接收失败！");
            plop = MapUtil.transJsonStrToObjectIgnoreCase(str, PLOParam.class);
            System.out.println("plop:" + plop.toString());
            result.put("resData", this.service.approvalEMPRequire(plop));
        } catch (MessageException e) {
            retCode = Constant.Result.ERROR;
            retMsg = e.getMessage();
        } catch (Exception e) {
            retCode = Constant.Result.ERROR;
            retMsg = Constant.Result.ERROR_MSG;
            log.error(Constant.Result.RETMSG, e);
        } finally {
            result.put(Constant.Result.RETCODE, retCode);
            result.put(Constant.Result.RETMSG, retMsg);
            return result;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/downloadFile")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("文件传来了");
        //通过数据库查询，要下载的文件的名字
        ExcelUtil.downloadFile(response,"testWord.doc");
        return "上传成功";
    }

    /**
     * 上传excel
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/import")
    public String addUser(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("文件传来了");
        //这里可以将文件名存起来，方便下载使用,文件上传过程将文件的MD5值和名字存在数据库中，通过MD5值判断是否上传过次文件
        //String md5 = DigestUtils.md5Hex(file.getBytes());
        String fileName = file.getOriginalFilename();
        ExcelUtil.uploadWord(file,fileName);
        return "上传成功";
    }


//	
//	public void downLoad(HttpServletRequest request, HttpServletResponse response){
//		// 得到要下载的文件名
//		String fileName = request.getParameter("filename"); // 23239283-92489-阿凡达.avi
//		fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
//		// 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
//		String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
//		String fileSaveRootPath =request.getSession().getServletContext().getRealPath("/");
//		// 通过文件名找出文件的所在目录
//		String path = findFileSavePathByFileName(fileName, fileSaveRootPath);
//		// 得到要下载的文件
//		File file = new File(path + "\\" + fileName);
//		// 如果文件不存在
//		if (!file.exists()) {
//			request.setAttribute("message", "您要下载的资源已被删除！！");
//			request.getRequestDispatcher("/message.jsp").forward(request, response);
//			return;
//		}
//		// 处理文件名
//		String realname = fileName.substring(fileName.indexOf("_") + 1);
//		// 设置响应头，控制浏览器下载该文件
//		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
//		// 读取要下载的文件，保存到文件输入流
//		FileInputStream in = new FileInputStream(path + "\\" + fileName);
//		// 创建输出流
//		OutputStream out = response.getOutputStream();
//		// 创建缓冲区
//		byte buffer[] = new byte[1024];
//		int len = 0;
//		// 循环将输入流中的内容读取到缓冲区当中
//		while ((len = in.read(buffer)) > 0) {
//			// 输出缓冲区的内容到浏览器，实现文件下载
//			out.write(buffer, 0, len);
//		}
//		// 关闭文件输入流
//		in.close();
//		// 关闭输出流
//		out.close();
//	}
//
//	/**
//	 * @Method: findFileSavePathByFileName
//	 * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
//	 * @Anthor:孤傲苍狼
//	 * @param filename
//	 *            要下载的文件名
//	 * @param saveRootPath
//	 *            上传文件保存的根目录，也就是/WEB-INF/upload目录
//	 * @return 要下载的文件的存储目录
//	 */
//	public String findFileSavePathByFileName(String filename, String saveRootPath) {
//		int hashcode = filename.hashCode();
//		int dir1 = hashcode & 0xf; // 0--15
//		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
//		String dir = saveRootPath + "\\" + dir1 + "\\" + dir2; // upload\2\3 upload\3\5
//		File file = new File(dir);
//		if (!file.exists()) {
//			// 创建目录
//			file.mkdirs();
//		}
//		return dir;
//	}

}
