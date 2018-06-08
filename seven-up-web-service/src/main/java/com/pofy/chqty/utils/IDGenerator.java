package com.pofy.chqty.utils;

import java.util.UUID;

/**
 * function - ID生成器
 * @author POFY
 * @date 2018/06/08
 * @version 1.0
 */
public class IDGenerator {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").substring(0,32);
    }
}
