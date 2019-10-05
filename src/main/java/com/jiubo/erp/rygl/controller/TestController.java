package com.jiubo.erp.rygl.controller;

import com.jiubo.erp.rygl.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class TestController {
    @Autowired
    private ITestService testService;


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
        String fileName = file.getOriginalFilename();
//        testService.batchImport(fileName, file);
        return "上传成功";
    }

}
