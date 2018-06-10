package com.pofy.chqty.service.sys.impl;

import com.pofy.chqty.dto.sys.SysUserDTO;
import com.pofy.chqty.entity.sys.SysUser;
import com.pofy.chqty.service.common.impl.BaseServiceImpl;
import com.pofy.chqty.service.sys.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * function - SysUserService接口实现
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Override
    public List<SysUserDTO> getAllUsers() throws Exception {
        List<SysUserDTO> resultList = new ArrayList<>();
        List<SysUser> queryList = listAll();
        for(SysUser user:queryList){
            SysUserDTO sysUserDTO = new SysUserDTO();
            BeanUtils.copyProperties(user,sysUserDTO);
            resultList.add(sysUserDTO);
        }
        return resultList;
    }
}
