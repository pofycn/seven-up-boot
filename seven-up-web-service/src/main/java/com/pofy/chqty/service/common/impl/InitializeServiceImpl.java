package com.pofy.chqty.service.common.impl;

import com.pofy.chqty.utils.RSAUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * function - 初始化服务实现类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-27
 **/
@Service
public class InitializeServiceImpl implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // 服务初始化时生成公钥密钥对
        RSAUtils.generateKeyPair();
    }
}
