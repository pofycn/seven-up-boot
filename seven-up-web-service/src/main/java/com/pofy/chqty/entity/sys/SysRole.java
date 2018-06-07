package com.pofy.chqty.entity.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * function - 系统角色对应实体
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
@Table(name = "sys_role")
public class SysRole {

    @Id
    private String roleId;

    private String roleName;

    private String roleDesc;

    private String roleOrder;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;
}


