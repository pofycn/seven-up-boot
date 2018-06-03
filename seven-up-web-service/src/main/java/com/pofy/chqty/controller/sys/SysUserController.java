package com.pofy.chqty.controller.sys;

import com.pofy.chqty.DTO.sys.SysUserDTO;
import com.pofy.chqty.common.annotation.Log;
import com.pofy.chqty.entity.sys.SysUser;
import com.pofy.chqty.service.sys.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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


    @Log(msg = "查询用户详情")
    @RequestMapping(value = "user",method = RequestMethod.POST,consumes = "application/json")
    public SysUserDTO getSysUser(@RequestBody SysUserDTO sysUserDTO){
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO,sysUser);
        SysUser result = sysUserService.get(sysUser);
        SysUserDTO resultDTO = new SysUserDTO();
        BeanUtils.copyProperties(result,resultDTO);
        return resultDTO;
    }

    @Log(msg = "查询所有用户")
    @RequestMapping(value = "allUsers",method = RequestMethod.GET)
    public List<SysUserDTO> getAllSysUser(){
        SysUser sysUser = new SysUser();
        List<SysUser> sysUserList = sysUserService.list(sysUser);
        List<SysUserDTO> resultList = new ArrayList<>();
        for(SysUser user:sysUserList){
            SysUserDTO tempDTO = new SysUserDTO();
            BeanUtils.copyProperties(user,tempDTO);
            resultList.add(tempDTO);
        }
        return resultList;
    }

}
