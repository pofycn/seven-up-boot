package com.pofy.chqty.controller.sys;

import com.pofy.chqty.entity.Result;
import com.pofy.chqty.utils.RSAUtils;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * function - 前后端通过rsa进行加/解密
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-27
 **/
@RestController
@RequestMapping(value = "v1/rsa/")
public class RsaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * function - 获取RSA密钥系数
     *
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-05-27
     */
    @RequestMapping(value = "rsaModulus", method = RequestMethod.POST)
    public Result getRsaModulus() {
        Result resp;
        logger.info("获取加密参数 ---开始");
        try {
            Map<String, String> result = new HashMap<>(64);
            result.put("e", RSAUtils.getPublicExponent());
            result.put("n", RSAUtils.getModulus());
            resp = ResultUtils.success(result);
        } catch (Exception e) {
            logger.error("获取公钥 ---异常:{}", e);
            resp = ResultUtils.exception(e);
        }
        logger.info("获取加密参数 ---结束");
        return resp;
    }
}
