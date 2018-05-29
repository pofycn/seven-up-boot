package com.pofy.chqty.common.interceptor;

import com.pofy.chqty.entity.Result;
import com.pofy.chqty.utils.ResultUtils;
import org.springframework.web.bind.annotation.*;

/**
 * function - 统一异常处理器
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-28
 **/
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    /**
     * function - 默认统一异常处理方法
     * @param e 异常实体
     * @return Result
     * @author POFY
     * @date 2018-05-28
     */
    @ExceptionHandler
    @ResponseStatus
    public Result runtimeExceptionHandler(Exception e){
        return ResultUtils.exception(e);
    }
}
