package com.pofy.chqty.Enum;

/**
 * function - 普通结果常量枚举
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-22
 **/
public enum  ResultEnum {
    Y("Y","Success"),N("N","Failed"),E("E","Exception");

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
