package com.erp.controller;
import com.erp.service.*;
import com.erp.common.utils.ApiResult;
import com.erp.dto.reponse.sys.SysRoleMenuRep;
import com.erp.dto.request.sys.SysRoleMenuCreateReq;
import com.erp.dto.request.sys.SysRoleMenuModifyReq;
import com.erp.entity.SysRoleMenuBean;


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
 * 角色与菜单对应关系
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:31
 */
@RestController
@RequestMapping(value = "/sys/sysrolemenu", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "角色与菜单对应关系")
public class SysRoleMenuController {
	@Autowired
	private SysRoleMenuService sysRoleMenuService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysrolemenu:create")
    public ApiResult create(SysRoleMenuCreateReq data)
    {
			SysRoleMenuBean entity=new SysRoleMenuBean();

			sysRoleMenuService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysrolemenu:modify")
    public  ApiResult modify(SysRoleMenuModifyReq data)
    {
        Example example = new Example(SysRoleMenuBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysRoleMenuBean entity=sysRoleMenuService.queryOneByExample(example);



			sysRoleMenuService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysrolemenu:del")
    public ApiResult del(Long id)
    {
			sysRoleMenuService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysrolemenu:info")
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysRoleMenuBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysRoleMenuBean entity= sysRoleMenuService.queryOneByExample(example);
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
    @RequiresPermissions("sys:sysrolemenu:list")
    public ApiResult<List<SysRoleMenuRep>> GetSysRoleMenuList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysRoleMenuBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysRoleMenuBean> pageInfo = sysRoleMenuService.queryPageListByExample(example,page,size);

        List<SysRoleMenuRep> list = new ArrayList<>();
        for(SysRoleMenuBean bean:pageInfo.getList())
        {
				SysRoleMenuRep item = new SysRoleMenuRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
