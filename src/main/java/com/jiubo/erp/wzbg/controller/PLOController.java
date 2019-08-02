package com.jiubo.erp.wzbg.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiubo.erp.wzbg.service.PLOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * 
 * @author mwl
 *
 */
@Controller
@RequestMapping("/wzbg")
public class PLOController {
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
	 * 文件上传 方法说明
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @author 作者 : mwl
	 * @version 创建时间：2019年7月25日 上午10:11:12
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/upload2")
	public void postUpload(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		// 文件上传核心类
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		// 判断request是否有文件上传
		if (multipartResolver.isMultipart(request)) {
			// 通过MultipartHttpServletRequest解析上传请求中的文件
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取上传请求中的所有文件
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 转换成spring支持的文件类型MultipartFile
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					File localFile = new File("D:/Output/" + file.getOriginalFilename());
					try {
						// 将上传文件写到指定位置,此处是本地文件夹
						file.transferTo(localFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	
	
	@ResponseBody
	@RequestMapping(value = "/downloadFile")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
//	public static void downloadFile(HttpServletResponse response,String fileName,String path){
		System.out.println("下载文件进来了，开始下载");
		String fileName="whoIsMe.doc";
		String path = "/ERP/WebContent/updateFile/";
		System.out.println("path:"+path);
        if (fileName != null) {
            //设置文件路径
            File file = new File(path);
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                try {
                    response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
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
