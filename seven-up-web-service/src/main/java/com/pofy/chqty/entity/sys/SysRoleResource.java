package com.pofy.chqty.entity.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * function - 系统角色资源对应实体类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
@Table(name = "sys_role_resource")
public class SysRoleResource {
    @Id
    private Integer id;

    private String roleId;

    private String resourceId;
}
