package com.pofy.chqty.controller.sys;

import com.pofy.chqty.common.annotation.Log;
import com.pofy.chqty.dto.sys.SysRoleResourceDTO;
import com.pofy.chqty.entity.Result;
import com.pofy.chqty.entity.sys.SysRoleResource;
import com.pofy.chqty.enums.ResultEnum;
import com.pofy.chqty.service.sys.SysRoleResourceService;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * function - 系统角色资源管理接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-10
 **/
@RestController
@RequestMapping(value = "/v1/sysRoleResource/")
public class SysRoleResourceController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SysRoleResourceController.class);

    @Autowired
    private SysRoleResourceService sysRoleResourceService;

    /**
     * function - 添加角色资源
     *
     * @param sysRoleResourceDTO - 角色资源信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "添加角色资源")
    @RequestMapping(value = "addRoleResource", method = RequestMethod.POST)
    public Result addRoleResource(@RequestBody SysRoleResourceDTO sysRoleResourceDTO) {
        Result resp;
        try {
            SysRoleResource sysRoleResource = new SysRoleResource();
            BeanUtils.copyProperties(sysRoleResourceDTO, sysRoleResource);
            sysRoleResourceService.save(sysRoleResource);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"添加角色资源成功");
        } catch (Exception e) {
            LOGGER.error("添加角色资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询角色资源
     *
     * @param sysRoleResourceDTO - 角色资源信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "查询角色资源")
    @RequestMapping(value = "roleResource", method = RequestMethod.POST)
    public Result getSysRoleResource(@RequestBody SysRoleResourceDTO sysRoleResourceDTO){
        Result resp;
        try {
            SysRoleResource sysRoleResource = new SysRoleResource();
            BeanUtils.copyProperties(sysRoleResourceDTO,sysRoleResource);
            SysRoleResource result = sysRoleResourceService.get(sysRoleResource);
            resp = ResultUtils.success(result);
        }catch (Exception e){
            LOGGER.error("查询角色资源", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询所有角色资源
     *
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "查询所有角色资源")
    @RequestMapping(value = "allRoleResources", method = RequestMethod.GET)
    public Result getAllRoleResources(){
        Result resp;
        try {
            List<SysRoleResource> resultList = sysRoleResourceService.listAll();
            resp = ResultUtils.success(resultList);
        }catch (Exception e){
            LOGGER.error("查询所有角色资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 更新角色资源
     * @param sysRoleResourceDTO 角色资源信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018-06-10
     */
    @Log(msg = "更新角色资源")
    @RequestMapping(value = "updateRole", method = RequestMethod.POST)
    public Result updateRoleResource(@RequestBody SysRoleResourceDTO sysRoleResourceDTO){
        Result resp;
        try {
            SysRoleResource sysRoleResource = new SysRoleResource();
            BeanUtils.copyProperties(sysRoleResourceDTO,sysRoleResource);
            sysRoleResourceService.update(sysRoleResource);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"更新角色资源成功");
        }catch (Exception e){
            LOGGER.error("更新角色资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 删除角色资源
     * @param sysRoleResourceDTO 角色资源信息
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-06-10
     */
    @Log(msg = "删除角色资源")
    @DeleteMapping(value = "deleteRole")
    public Result deleteRole(@RequestBody SysRoleResourceDTO sysRoleResourceDTO){

        Result resp;
        try {
            SysRoleResource sysRoleResource = new SysRoleResource();
            BeanUtils.copyProperties(sysRoleResourceDTO,sysRoleResource);
            sysRoleResourceService.delete(sysRoleResource);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"删除角色资源成功");

        }catch (Exception e){
            LOGGER.error("删除角色资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

}
