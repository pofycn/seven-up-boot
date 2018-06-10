package com.pofy.chqty.controller.sys;

import com.pofy.chqty.common.annotation.Log;
import com.pofy.chqty.dto.sys.SysUserDTO;
import com.pofy.chqty.entity.Result;
import com.pofy.chqty.entity.sys.SysUser;
import com.pofy.chqty.enums.ResultEnum;
import com.pofy.chqty.service.sys.SysUserService;
import com.pofy.chqty.utils.IDGenerator;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * function - 系统用户管理接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-20
 **/
@RestController
@RequestMapping(value = "/v1/sysUser/")
public class SysUserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * function - 添加用户
     *
     * @param sysUserDTO - 用户信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/08
     */
    @Log(msg = "查询用户详情")
    @RequestMapping(value = "user", method = RequestMethod.POST, consumes = "application/json")
    public Result getSysUser(@RequestBody SysUserDTO sysUserDTO) {
        Result resp;
        try {
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(sysUserDTO, sysUser);
            SysUser result = sysUserService.get(sysUser);
            SysUserDTO resultDTO = new SysUserDTO();
            BeanUtils.copyProperties(result, resultDTO);
            resp = ResultUtils.success(resultDTO);
        } catch (Exception e) {
            LOGGER.error("查询用户详情", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询所有用户
     *
     * @return com.pofy.chqty.entity.Result
     */
    @Log(msg = "查询所有用户")
    @RequestMapping(value = "allUsers", method = RequestMethod.GET)
    public Result getAllSysUser() {
        Result resp;
        try {
            List<SysUserDTO> resultList = sysUserService.getAllUsers();
            resp = ResultUtils.success(resultList);
        } catch (Exception e) {
            LOGGER.error("查询所有用户", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 添加用户
     *
     * @param userDTO - 用户信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/08
     */
    @Log(msg = "添加用户")
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public Result addUser(@RequestBody SysUserDTO userDTO) {
        Result resp;
        try {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(userDTO, user);
            user.setUserId(IDGenerator.uuid());
            user.setCreatedDate(new Date());
            sysUserService.save(user);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"添加用户成功");
        } catch (Exception e) {
            LOGGER.error("添加用户失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 更新用户
     *
     * @param userDTO - 用户信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/08
     */
    @Log(msg = "更新用户")
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public Result updateUser(SysUserDTO userDTO) {
        Result resp;
        try {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(userDTO, user);
            int result = sysUserService.update(user);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"更新用户成功");
        } catch (Exception e) {
            LOGGER.error("更新用户失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 删除用户
     *
     * @param userDTO - 用户信息
     * @return com.pofy.chqty.entity.Result
     */
    @Log(msg = "删除用户")
    @DeleteMapping(value = "deleteUser")
    public Result deleteUser(@RequestBody SysUserDTO userDTO){
        Result resp;
        try {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(userDTO, user);
            sysUserService.delete(user);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"删除用户成功");
        }catch (Exception e){
            LOGGER.error("删除用户失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

}
