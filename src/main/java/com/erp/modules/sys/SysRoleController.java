package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;

import com.erp.dto.reponse.sys.SysRoleRep;
import com.erp.dto.request.sys.SysRoleCreateReq;
import com.erp.dto.request.sys.SysRoleModifyReq;
import com.erp.entity.sys.SysRoleBean;
import com.erp.entity.sys.SysRoleDeptBean;
import com.erp.entity.sys.SysRoleMenuBean;
import com.erp.service.sys.SysRoleService;


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
import java.util.Date;
import java.util.List;

/**
 * 角色
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:31
 */
@RestController
@RequestMapping(value = "/sys/sysrole", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "角色")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
   /* @RequiresPermissions("sys:sysrole:create")*/
    public ApiResult create(SysRoleCreateReq data) {
        SysRoleBean entity = new SysRoleBean();
        entity.setRemark(data.getRemark());
        entity.setRoleName(data.getRoleName());
        entity.setCreateTime(new Date());

        List<SysRoleDeptBean> deptList = new ArrayList<>();
        if(data.getDeptIdList().size()>0) {
            for (Long s : data.getDeptIdList()) {
                if(s<=0)
                    continue;;
                SysRoleDeptBean m = new SysRoleDeptBean();
                m.setDeptId(s);
                deptList.add(m);
            }
        }
        if(deptList.size()<=0) {
            return  ApiResult.Fail("部门不能为空!");
        }

        List<SysRoleMenuBean> menuList = new ArrayList<>();
        if(data.getMenuIdList().size()>0) {
            for (Long s : data.getMenuIdList()) {
                if(s<=0)
                    continue;;
                SysRoleMenuBean m = new SysRoleMenuBean();
                m.setMenuId(s);
                menuList.add(m);
            }
        }
        if(menuList.size()<=0) {
            return  ApiResult.Fail("菜单不能为空!");
        }

        sysRoleService.insert(entity,deptList,menuList);
        return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysrole:modify")
    public  ApiResult modify(SysRoleModifyReq data)
    {
        Example example = new Example(SysRoleBean.class);
        example.createCriteria().andEqualTo("roleId",data.roleId);

            SysRoleBean entity=sysRoleService.queryOneByExample(example);



			sysRoleService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysrole:del")
    public ApiResult del(Long roleId)
    {
			sysRoleService.deleteByPrimaryKey(roleId);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysrole:info")
    public  ApiResult info(Long roleId)
    {
        Example example = new Example(SysRoleBean.class);
        example.createCriteria().andEqualTo("roleId",roleId);
            SysRoleBean entity= sysRoleService.queryOneByExample(example);
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
    @RequiresPermissions("sys:sysrole:list")
    public ApiResult<List<SysRoleRep>> GetSysRoleList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysRoleBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysRoleBean> pageInfo = sysRoleService.queryPageListByExample(example,page,size);

        List<SysRoleRep> list = new ArrayList<>();
        for(SysRoleBean bean:pageInfo.getList())
        {
				SysRoleRep item = new SysRoleRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
