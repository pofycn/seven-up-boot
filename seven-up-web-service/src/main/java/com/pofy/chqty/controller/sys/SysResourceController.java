package com.pofy.chqty.controller.sys;

import com.pofy.chqty.common.annotation.Log;
import com.pofy.chqty.dto.sys.SysResourceDTO;
import com.pofy.chqty.entity.Result;
import com.pofy.chqty.entity.sys.SysResource;
import com.pofy.chqty.enums.ResultEnum;
import com.pofy.chqty.service.sys.SysResourceService;
import com.pofy.chqty.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * function - 系统资源管理接口
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-10
 **/
@RestController
@RequestMapping(value = "/v1/sysResource/")
public class SysResourceController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SysResourceController.class);

    @Autowired
    private SysResourceService sysResourceService;

    /**
     * function - 添加角色
     *
     * @param sysResourceDTO - 角色信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "添加系统资源")
    @RequestMapping(value = "addResource", method = RequestMethod.POST)
    public Result addResource(@RequestBody SysResourceDTO sysResourceDTO) {
        Result resp;
        try {
            SysResource sysResource = new SysResource();
            BeanUtils.copyProperties(sysResourceDTO, sysResource);
            sysResourceService.save(sysResource);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"添加系统资源成功");
        } catch (Exception e) {
            LOGGER.error("添加系统资源", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询资源
     *
     * @param sysResourceDTO - 资源信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "查询资源")
    @RequestMapping(value = "resource", method = RequestMethod.POST)
    public Result getSysResource(@RequestBody SysResourceDTO sysResourceDTO){
        Result resp;
        try {
            SysResource sysResource = new SysResource();
            BeanUtils.copyProperties(sysResourceDTO,sysResource);
            SysResource result = sysResourceService.get(sysResource);
            resp = ResultUtils.success(result);
        }catch (Exception e){
            LOGGER.error("查询资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 查询所有资源
     *
     * @return com.pofy.chqty.entity.Result
     * @date 2018/06/10
     */
    @Log(msg = "查询所有资源")
    @RequestMapping(value = "allResources", method = RequestMethod.GET)
    public Result getAllResources(){
        Result resp;
        try {
            List<SysResource> resultList = sysResourceService.listAll();
            resp = ResultUtils.success(resultList);
        }catch (Exception e){
            LOGGER.error("查询所有资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 更新资源
     * @param sysResourceDTO 资源信息
     * @return com.pofy.chqty.entity.Result
     * @date 2018-06-10
     */
    @Log(msg = "更新资源")
    @RequestMapping(value = "updateResource", method = RequestMethod.POST)
    public Result updateRole(@RequestBody SysResourceDTO sysResourceDTO){
        Result resp;
        try {
            SysResource sysResource = new SysResource();
            BeanUtils.copyProperties(sysResourceDTO,sysResource);
            sysResourceService.update(sysResource);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"更新资源成功");
        }catch (Exception e){
            LOGGER.error("更新资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }

    /**
     * function - 删除资源
     * @param sysResourceDTO 资源信息
     * @return com.pofy.chqty.entity.Result
     * @author POFY
     * @date 2018-06-10
     */
    @Log(msg = "删除资源")
    @DeleteMapping(value = "deleteRole")
    public Result deleteRole(@RequestBody SysResourceDTO sysResourceDTO){

        Result resp;
        try {
            SysResource sysResource = new SysResource();
            BeanUtils.copyProperties(sysResourceDTO,sysResource);
            sysResourceService.delete(sysResource);
            resp = ResultUtils.success(ResultEnum.Y.getCode(),ResultEnum.Y.getMessage(),"删除资源成功");
        }catch (Exception e){
            LOGGER.error("删除资源失败", e);
            resp = ResultUtils.exception(e);
        }
        return resp;
    }
}
