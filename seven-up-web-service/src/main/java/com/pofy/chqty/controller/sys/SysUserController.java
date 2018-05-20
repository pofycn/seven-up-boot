package com.pofy.chqty.controller.sys;

import com.pofy.chqty.entity.sys.SysUser;
import com.pofy.chqty.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * function - 系统用户controller
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
@RestController
@RequestMapping(value = "/v1/sysUser/")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "users",method = RequestMethod.GET)
    public List<SysUser> getSysUser(){
        SysUser sysUser = new SysUser();
        List<SysUser> result = sysUserService.list(sysUser);
        return result;
    }

}
