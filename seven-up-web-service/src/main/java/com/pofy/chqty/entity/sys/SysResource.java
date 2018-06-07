package com.pofy.chqty.entity.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * function - 系统资源对应实体
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
@Table(name = "sys_resource")
public class SysResource{

    @Id
    private String resId;

    private String resName;

    private Integer resParentId;

    private String resUrl;

    private String resTarget;

    private String resImage;

    private String resType;

    private String resDesc;

    private Integer resOrder;
}
