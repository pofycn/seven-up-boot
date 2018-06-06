package com.pofy.chqty.controller.common;

import com.pofy.chqty.entity.Result;
import com.pofy.chqty.service.common.FileService;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function - 文件操作controller
 *
 * @author POFY
 * @version 1.0
 * @date 2018/06/06
 */
@RestController
@RequestMapping("v1/file/")
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "uploadSingleFile", method = RequestMethod.POST)
    public Result uploadSingleFile(HttpServletRequest request, MultipartFile file) {
        Result resp;
        try {
            String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String result = fileService.uploadSingleFile(file, uploadPath);
            resp = ResultUtils.success(result);
        } catch (Exception e) {
            logger.error("上传单文件异常:{}", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    @RequestMapping(value = "uploadMultipleFile", method = RequestMethod.POST)
    public Result uploadMultipleFile(HttpServletRequest request, MultipartFile[] files) {
        Result resp;
        try {
            String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String result = fileService.uploadMutipleFile(files, uploadPath);
            resp = ResultUtils.success(result);
        } catch (Exception e) {
            logger.error("上传多文件异常:{}", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }
}
