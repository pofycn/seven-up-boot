package com.pofy.chqty.entity.sys;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * function - 操作日志表对应实体
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-07
 **/
@Data
@Table(name = "sys_log")
public class SysLog {

    @Id
    private String actionId;

    private String userId;

    private Date actionDate;

    private String actionIp;

    private String actionModule;

    private Integer actionType;

    private String actionParams;
}
