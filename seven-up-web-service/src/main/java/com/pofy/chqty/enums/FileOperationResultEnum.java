package com.pofy.chqty.enums;

/**
 * function - 文件操作结果枚举类
 * @author POFY
 * @date 2018/06/06
 * @version 1.0
 */
public enum FileOperationResultEnum {
    /**
     * 上传成功
     */
    UPLOAD_SUCCESS(1,"上传成功"),
    /**
     * 上传失败
     */
    UPLOAD_FAILED(2,"上传失败");

    private Integer code;

    private String message;

    FileOperationResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
