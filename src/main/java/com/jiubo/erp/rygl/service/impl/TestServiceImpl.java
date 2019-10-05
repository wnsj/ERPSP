package com.jiubo.erp.rygl.service.impl;

import com.jiubo.erp.common.ExcelUtil;
import com.jiubo.erp.rygl.dao.AccountMapper;
import com.jiubo.erp.rygl.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;



@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private AccountMapper userMapper;



    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void batchImport(String fileName, MultipartFile file) throws Exception {

        System.out.println("上传的数据："+ExcelUtil.updateExcel(fileName,file,true).toString());
    }

    public String wordImport(String fileName, MultipartFile file) throws Exception{
        System.out.println("上传word文件："+ExcelUtil.uploadWord(file,fileName));
        return ExcelUtil.uploadWord(file,fileName);
    }
}
