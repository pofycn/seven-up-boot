package com.pofy.chqty.entity.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * function - 系统用户表对应实体
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
@Data
@Table(name = "sys_user")
public class SysUser {
    @Id
    private String id;

    private String userName;

    private String userPassword;

    private String randomCode;

    private String userStatus;

    private String userMobile;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    private Integer roleId;
}
