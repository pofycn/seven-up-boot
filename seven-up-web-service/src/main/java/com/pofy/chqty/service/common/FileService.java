package com.pofy.chqty.service.common;

import org.springframework.web.multipart.MultipartFile;

/**
 * function - 文件服务service接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018/06/06
 */
public interface FileService {
    /**
     * function - 上传单文件
     *
     * @param file 文件
     * @param path 上传路径
     * @return String 是否上传成功消息
     * @throws Exception 文件读写异常
     * @author POFY
     * @date 2018/06/06
     */
    String uploadSingleFile(MultipartFile file, String path) throws Exception;

    /**
     * function - 上传多文件
     *
     * @param files 文件数组
     * @param path  上传路径
     * @return String 是否上传成功消息
     * @throws Exception 文件读写异常
     * @author POFY
     * @date 2018/06/06
     */
    String uploadMutipleFile(MultipartFile[] files, String path) throws Exception;
}
