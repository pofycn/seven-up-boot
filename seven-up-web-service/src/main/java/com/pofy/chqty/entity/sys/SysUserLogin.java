package com.pofy.chqty.entity.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * function - 系统用户登录记录对应实体
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
@Table(name = "sys_user_login")
public class SysUserLogin {
    @Id
    private String id;

    private String userId;

    private Date loginDate;

    private String loginIp;

    private String loginTerminal;

    private String loginBrowserType;
}
