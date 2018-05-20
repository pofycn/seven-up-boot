package com.pofy.chqty.entity.sys;

import lombok.Data;

import java.util.Date;

/**
 * function - 系统用户表对应实体
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
@Data
public class SysUser {
    private String id;

    private String userName;

    private String userPassword;

    private String randomCode;

    private String userStatus;

    private String userRealName;

    private String userMobile;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    private Integer roleId;
}
