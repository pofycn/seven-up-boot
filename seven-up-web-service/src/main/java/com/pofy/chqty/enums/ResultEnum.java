package com.pofy.chqty.enums;

/**
 * function - 普通结果常量枚举
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-22
 **/
public enum  ResultEnum {
    /**
     * 成功
     */
    Y("Y","Success"),
    /**
     * 失败
     */
    N("N","Failed"),
    /**
     * 异常
     */
    E("E","Exception");

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
