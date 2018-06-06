package com.pofy.chqty.service.common.impl;

import com.pofy.chqty.enums.FileOperationResultEnum;
import com.pofy.chqty.service.common.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * function - 文件服务service接口实现类
 *
 * @author POFY
 * @version 1.0
 * @date 2018/06/06
 */
@Service
public class FileServiceImpl implements FileService {

    private final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadSingleFile(MultipartFile file, String path) throws Exception {
        File dir = new File(path);
        Boolean dirResult;
        if (!dir.exists()) {
            dirResult = dir.mkdirs();
            logger.info("创建目录:{}", dirResult);
        }
        executeUpload(path, file);
        return FileOperationResultEnum.UPLOAD_SUCCESS.getMessage();
    }

    @Override
    public String uploadMutipleFile(MultipartFile[] files, String path) throws Exception {
        File dir = new File(path);
        Boolean dirResult;
        if (!dir.exists()) {
            dirResult = dir.mkdirs();
            logger.info("创建目录成功?{}", dirResult);
        }
        for (MultipartFile file : files) {
            if (file != null) {
                executeUpload(path, file);
            }
        }
        return FileOperationResultEnum.UPLOAD_SUCCESS.getMessage();
    }

    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception 异常
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
