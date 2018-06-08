package com.pofy.chqty.dto.sys;

import lombok.Data;

import java.util.Date;

/**
 * function - 操作日志表DTO
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
public class SysLogDTO {

    private String actionId;

    private String userId;

    private Date actionDate;

    private String actionIp;

    private String actionModule;

    private Integer actionType;

    private String actionParams;
}
