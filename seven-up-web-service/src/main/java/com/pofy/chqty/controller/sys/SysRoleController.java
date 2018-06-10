package com.pofy.chqty.controller.sys;

import com.pofy.chqty.common.annotation.Log;
import com.pofy.chqty.dto.sys.SysRoleDTO;
import com.pofy.chqty.entity.Result;
import com.pofy.chqty.entity.sys.SysRole;
import com.pofy.chqty.enums.ResultEnum;
import com.pofy.chqty.service.sys.SysRoleService;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * function - 系统角色管理接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-10
 **/
@RestController
@RequestMapping(value = "/v1/sysRole/")
public class SysRoleController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * function - 添加角色
     *
     * @param sysRoleDTO - 角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "添加角色")
    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public Result addUser(@RequestBody SysRoleDTO sysRoleDTO) {
        Result resp;
        try {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(sysRoleDTO, sysRole);
            sysRole.setCreatedDate(new Date());
            sysRoleService.save(sysRole);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"添加角色成功");
        } catch (Exception e) {
            LOGGER.error("添加角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询角色
     *
     * @param sysRoleDTO - 角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "查询角色")
    @RequestMapping(value = "role", method = RequestMethod.POST)
    public Result getSysRole(@RequestBody SysRoleDTO sysRoleDTO){
        Result resp;
        try {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(sysRoleDTO,sysRole);
            SysRole result = sysRoleService.get(sysRole);
            resp = ResultUtils.success(result);
        }catch (Exception e){
            LOGGER.error("查询角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询所有角色
     *
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "查询所有角色")
    @RequestMapping(value = "allRoles", method = RequestMethod.GET)
    public Result getAllSysRole(){
        Result resp;
        try {
            List<SysRole> resultList = sysRoleService.listAll();
            resp = ResultUtils.success(resultList);
        }catch (Exception e){
            LOGGER.error("查询所有角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 更新角色
     * @param sysRoleDTO 角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018-06-10
     */
    @Log(msg = "更新角色")
    @RequestMapping(value = "updateRole", method = RequestMethod.POST)
    public Result updateRole(@RequestBody SysRoleDTO sysRoleDTO){
        Result resp;
        try {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(sysRoleDTO,sysRole);
            sysRoleService.update(sysRole);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"更新角色成功");
        }catch (Exception e){
            LOGGER.error("更新角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 删除角色
     * @param sysRoleDTO 角色信息
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-06-10
     */
    @Log(msg = "删除角色")
    @DeleteMapping(value = "deleteRole")
    public Result deleteRole(@RequestBody SysRoleDTO sysRoleDTO){

        Result resp;
        try {
            SysRole sysRole = new SysRole();
            BeanUtils.copyProperties(sysRoleDTO,sysRole);
            sysRoleService.delete(sysRole);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"删除角色成功");

        }catch (Exception e){
            LOGGER.error("删除角色失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

}
