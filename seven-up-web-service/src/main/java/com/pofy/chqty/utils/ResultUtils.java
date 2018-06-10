package com.pofy.chqty.utils;

import com.pofy.chqty.enums.ResultEnum;
import com.pofy.chqty.entity.Result;

import java.util.Date;

/**
 * function - ResultUtils 用于封装向前端返回统一的response
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-22
 **/
public class ResultUtils {

    /**
     * function -  返回成功，传入返回体具体出參
     *
     * @param object - 返回结果体
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-05-22
     */
    public static Result success(Object object) {
        Result<Object> result = new Result<>();
        result.setCode(ResultEnum.Y.getCode());
        result.setMessage(ResultEnum.Y.getMessage());
        result.setBody(object);
        return result;
    }

    /**
     * function - 无参正常返回
     *
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-05-22
     */
    public static Result success() {
        return success(null);
    }

    /**
     * function -自定义成功返回信息
     *
     * @param code 成功返回码
     * @param msg  成功信息
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-05-22
     */
    public static Result success(String code, String msg, Object body) {
        return new Result<>(code, msg, body, new Date());
    }

    /**
     * function -自定义错误信息
     *
     * @param code 错误返回码
     * @param msg  错误消息
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-05-22
     */
    public static Result error(String code, String msg, Object body) {
        return new Result<>(code, msg, body, new Date());
    }

    /**
     * function - 异常返回
     *
     * @param e - 异常实体
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-05-22
     */
    public static Result exception(Exception e) {
        return new Result<>(ResultEnum.E.getCode(), e.getMessage(), null, new Date());
    }

}
