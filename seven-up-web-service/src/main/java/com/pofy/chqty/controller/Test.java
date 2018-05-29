package com.pofy.chqty.controller;

import com.pofy.chqty.entity.Result;
import com.pofy.chqty.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***********************************************************
 * function -  
 * Copyright (c) @author chenn001 2018/05/29
 * @version 1.0
 ***********************************************************/
@RestController
@RequestMapping("v1/test")
public class Test {
    @RequestMapping("/test111")
    public Result test(){
        int a = 10/0;
        return ResultUtils.success(a);
    }

}
