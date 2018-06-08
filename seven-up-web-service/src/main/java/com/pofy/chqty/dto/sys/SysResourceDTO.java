package com.pofy.chqty.dto.sys;

import lombok.Data;

import javax.persistence.Id;

/**
 * function - 系统资源DTO
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
public class SysResourceDTO {

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
