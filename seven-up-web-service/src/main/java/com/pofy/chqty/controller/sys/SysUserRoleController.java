package com.pofy.chqty.controller.sys;

import com.pofy.chqty.common.annotation.Log;
import com.pofy.chqty.dto.sys.SysUserDTO;
import com.pofy.chqty.dto.sys.SysUserRoleDTO;
import com.pofy.chqty.entity.Result;
import com.pofy.chqty.entity.sys.SysUserRole;
import com.pofy.chqty.enums.ResultEnum;
import com.pofy.chqty.service.sys.SysUserRoleService;
import com.pofy.chqty.utils.IDGenerator;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * function - 系统用户管理接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
@RestController
@RequestMapping(value = "/v1/sysUserRole/")
public class SysUserRoleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SysUserRoleController.class);

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * function - 查询用户角色
     *
     * @param sysUserRoleDTO - 用户角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/08
     */
    @Log(msg = "查询用户角色")
    @RequestMapping(value = "userRole", method = RequestMethod.POST, consumes = "application/json")
    public Result getSysUserRole(@RequestBody SysUserRoleDTO sysUserRoleDTO) {
        Result resp;
        try {
            SysUserRole sysUserRole = new SysUserRole();
            BeanUtils.copyProperties(sysUserRoleDTO, sysUserRole);
            SysUserRole result = sysUserRoleService.get(sysUserRole);
            SysUserDTO resultDTO = new SysUserDTO();
            BeanUtils.copyProperties(result, resultDTO);
            resp = ResultUtils.success(resultDTO);
        } catch (Exception e) {
            LOGGER.error("查询用户角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询所有用户角色
     *
     * @return com.pofy.chqty.entity.Result
     */
    @Log(msg = "查询所有用户角色")
    @RequestMapping(value = "allUserRoles", method = RequestMethod.GET)
    public Result getAllSysUserRoles() {
        Result resp;
        try {
            List<SysUserRole> resultList = sysUserRoleService.listAll();
            resp = ResultUtils.success(resultList);
        } catch (Exception e) {
            LOGGER.error("查询所有用户角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 添加用户角色
     *
     * @param sysUserRole - 用户角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/08
     */
    @Log(msg = "添加用户角色")
    @RequestMapping(value = "addUserRole", method = RequestMethod.POST)
    public Result addUser(@RequestBody SysUserRole sysUserRole) {
        Result resp;
        try {
            SysUserRole result = new SysUserRole();
            BeanUtils.copyProperties(sysUserRole, result);
            sysUserRole.setId(IDGenerator.uuid());
            sysUserRoleService.save(result);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"添加用户角色成功");
        } catch (Exception e) {
            LOGGER.error("添加用户角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 更新用户角色
     *
     * @param sysUserRoleDTO -  用户角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/08
     */
    @Log(msg = "更新用户角色")
    @RequestMapping(value = "updateUserRole", method = RequestMethod.POST)
    public Result updateUser(SysUserRoleDTO sysUserRoleDTO) {
        Result resp;
        try {
            SysUserRole userRole = new SysUserRole();
            BeanUtils.copyProperties(sysUserRoleDTO, userRole);
            sysUserRoleService.update(userRole);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"更新用户角色成功");
        } catch (Exception e) {
            LOGGER.error("更新用户角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 删除用户角色
     *
     * @param sysUserRoleDTO - 用户角色信息
     * @return com.pofy.chqty.entity.Result
     */
    @Log(msg = "删除用户角色")
    @DeleteMapping(value = "deleteUser")
    public Result deleteUser(@RequestBody SysUserRoleDTO sysUserRoleDTO){
        Result resp;
        try {
            SysUserRole sysUserRole = new SysUserRole();
            BeanUtils.copyProperties(sysUserRoleDTO, sysUserRole);
            sysUserRoleService.delete(sysUserRole);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"删除用户角色成功");
        }catch (Exception e){
            LOGGER.error("删除用户角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

}
