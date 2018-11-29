package com.erp.modules.sys;
import com.erp.service.sys.*;
import com.erp.common.utils.ApiResult;
import com.erp.dto.reponse.sys.SysRoleDeptRep;
import com.erp.dto.request.sys.SysRoleDeptCreateReq;
import com.erp.dto.request.sys.SysRoleDeptModifyReq;
import com.erp.entity.sys.SysRoleDeptBean;
import com.erp.service.sys.SysRoleDeptService;

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
 * 角色与部门对应关系
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:31
 */
@RestController
@RequestMapping(value = "/sys/sysroledept", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "角色与部门对应关系")
public class SysRoleDeptController {
	@Autowired
	private SysRoleDeptService sysRoleDeptService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysroledept:create")
    public ApiResult create(SysRoleDeptCreateReq data)
    {
			SysRoleDeptBean entity=new SysRoleDeptBean();

			sysRoleDeptService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysroledept:modify")
    public  ApiResult modify(SysRoleDeptModifyReq data)
    {
        Example example = new Example(SysRoleDeptBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysRoleDeptBean entity=sysRoleDeptService.queryOneByExample(example);



			sysRoleDeptService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysroledept:del")
    public ApiResult del(Long id)
    {
			sysRoleDeptService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysroledept:info")
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysRoleDeptBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysRoleDeptBean entity= sysRoleDeptService.queryOneByExample(example);
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
    @RequiresPermissions("sys:sysroledept:list")
    public ApiResult<List<SysRoleDeptRep>> GetSysRoleDeptList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysRoleDeptBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysRoleDeptBean> pageInfo = sysRoleDeptService.queryPageListByExample(example,page,size);

        List<SysRoleDeptRep> list = new ArrayList<>();
        for(SysRoleDeptBean bean:pageInfo.getList())
        {
				SysRoleDeptRep item = new SysRoleDeptRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
