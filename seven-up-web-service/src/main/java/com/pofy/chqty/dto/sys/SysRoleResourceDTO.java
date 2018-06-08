package com.pofy.chqty.dto.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * function - 系统角色资源DTO
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
public class SysRoleResourceDTO {
    private Integer id;

    private String roleId;

    private String resourceId;
}
