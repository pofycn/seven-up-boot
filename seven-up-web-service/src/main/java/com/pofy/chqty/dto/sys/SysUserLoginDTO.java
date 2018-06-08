package com.pofy.chqty.dto.sys;

import lombok.Data;

import java.util.Date;

/**
 * function - 系统用户登录记录DTO
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
public class SysUserLoginDTO {

    private String id;

    private String userId;

    private Date loginDate;

    private String loginIp;

    private String loginTerminal;

    private String loginBrowserType;
}
