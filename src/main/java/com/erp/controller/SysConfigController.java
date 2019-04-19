package com.erp.controller;

import com.erp.common.utils.ApiResult;
import com.erp.dto.reponse.sys.SysConfigRep;
import com.erp.dto.request.sys.SysConfigCreateReq;
import com.erp.dto.request.sys.SysConfigModifyReq;

import com.erp.entity.SysConfigBean;
import com.erp.service.*;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统配置信息表
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:31
 */
@RestController
@RequestMapping(value = "/sys/sysconfig", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "系统配置信息表")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;



    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysconfig:create")
    public ApiResult create(SysConfigCreateReq data)
    {

			SysConfigBean entity=new SysConfigBean();

			sysConfigService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysconfig:modify")
    public  ApiResult modify(SysConfigModifyReq data)
    {
        Example example = new Example(SysConfigBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysConfigBean entity=sysConfigService.queryOneByExample(example);

			sysConfigService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysconfig:del")
    public ApiResult del(Integer id)
    {
        sysConfigService.deleteByPrimaryKey(Long.parseLong(id.toString()));
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysconfig:info")
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysConfigBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysConfigBean entity= sysConfigService.queryOneByExample(example);
        return ApiResult.Success(entity);
    }

    @ApiOperation(value = "分页获取")
    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "page", value = "第几页", dataType = "String"),
                    @ApiImplicitParam(paramType ="query", name = "size", value = "每页显示条数", dataType = "String")
            })
    @ResponseBody()
    @RequiresPermissions("sys:sysconfig:list")
    public ApiResult<List<SysConfigRep>> GetSysConfigList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysConfigBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysConfigBean> pageInfo = sysConfigService.queryPageListByExample(example,page,size);

        List<SysConfigRep> list = new ArrayList<>();
        for(SysConfigBean bean:pageInfo.getList())
        {
				SysConfigRep item = new SysConfigRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
