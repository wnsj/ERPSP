package com.jiubo.erp.rygl.service;

import org.springframework.web.multipart.MultipartFile;


public interface ITestService {
    void batchImport(String fileName, MultipartFile file) throws Exception;
}
