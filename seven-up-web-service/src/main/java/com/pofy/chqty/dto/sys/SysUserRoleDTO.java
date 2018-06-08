package com.pofy.chqty.dto.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * function - 用户角色实体类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-08
 **/
@Data
public class SysUserRoleDTO {

    private String id;

    private String userId;

    private String roleId;
}
