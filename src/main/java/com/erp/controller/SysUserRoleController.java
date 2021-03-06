package com.erp.controller;

import com.erp.common.utils.ApiResult;
import com.erp.dto.reponse.sys.SysUserRoleRep;
import com.erp.dto.request.sys.SysUserRoleCreateReq;
import com.erp.dto.request.sys.SysUserRoleModifyReq;
import com.erp.entity.SysUserRoleBean;
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
 * 用户与角色对应关系
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:30
 */
@RestController
@RequestMapping(value = "/sys/sysuserrole", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "用户与角色对应关系")
public class SysUserRoleController {
	@Autowired
	private SysUserRoleService sysUserRoleService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysuserrole:create")
    public ApiResult create(SysUserRoleCreateReq data)
    {
			SysUserRoleBean entity=new SysUserRoleBean();

			sysUserRoleService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysuserrole:modify")
    public  ApiResult modify(SysUserRoleModifyReq data)
    {
        Example example = new Example(SysUserRoleBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysUserRoleBean entity=sysUserRoleService.queryOneByExample(example);



			sysUserRoleService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysuserrole:del")
    public ApiResult del(Long id)
    {
			sysUserRoleService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysuserrole:info")
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysUserRoleBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysUserRoleBean entity= sysUserRoleService.queryOneByExample(example);
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
    @RequiresPermissions("sys:sysuserrole:list")
    public ApiResult<List<SysUserRoleRep>> GetSysUserRoleList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysUserRoleBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysUserRoleBean> pageInfo = sysUserRoleService.queryPageListByExample(example,page,size);

        List<SysUserRoleRep> list = new ArrayList<>();
        for(SysUserRoleBean bean:pageInfo.getList())
        {
				SysUserRoleRep item = new SysUserRoleRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
