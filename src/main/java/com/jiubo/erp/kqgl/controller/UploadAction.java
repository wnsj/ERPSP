package com.jiubo.erp.kqgl.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 用于文件上传的action
 * 表单示例:
 * <form action="${pageContext.request.contextPath}/smvcUploadAction/uploadFiles.do" method="post" enctype="multipart/form-data">
 * <input type="file" name="files"><br>
 * <input type="file" name="files"><br>
 * <input type="submit" value="提交">
 * </form>
 */
@Controller
@RequestMapping("/uploadAction")
public class UploadAction {

    @RequestMapping("/uploadFiles")
    public String uploadFiles(@RequestParam MultipartFile[] files, HttpServletRequest request) {
        System.out.println("method run ....");
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    throw new RuntimeException("文件不能为空！");
                } else {
                    String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, file.getOriginalFilename()));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return "forward:/index.jsp";
    }
}
