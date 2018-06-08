package com.pofy.chqty.dto.sys;

import lombok.Data;

import java.util.Date;

/**
 * function - 系统角色DTP
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
public class SysRoleDTO {

    private String roleId;

    private String roleName;

    private String roleDesc;

    private String roleOrder;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;
}


