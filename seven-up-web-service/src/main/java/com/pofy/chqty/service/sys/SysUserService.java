package com.pofy.chqty.service.sys;

import com.pofy.chqty.dto.sys.SysUserDTO;
import com.pofy.chqty.entity.sys.SysUser;
import com.pofy.chqty.service.common.BaseService;

import java.util.List;

/**
 * function - SysUserService接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
public interface SysUserService extends BaseService<SysUser> {

    public List<SysUserDTO> getAllUsers() throws Exception;
}
