package com.pofy.chqty.enums;

/**
 * function - 系统角色枚举类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-10
 **/
public enum SysRoleEnum {
    /**
     * 超级管理员
     */
    SUPER_ADMIN(1,"超级管理员"),
    /**
     * 普通管理员
     */
    NORMAL_ADMIN(2,"普通管理员");

    SysRoleEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 角色码
     */
    private Integer code;

    /**
     * 角色描述
     */
    private String description;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static SysRoleEnum getSysRoleEnum(Integer code){
        switch (code){
            case 1:return SysRoleEnum.SUPER_ADMIN;
            case 2:return SysRoleEnum.NORMAL_ADMIN;
            default:return null;
        }
    }
}
