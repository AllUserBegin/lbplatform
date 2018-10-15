package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;
import com.erp.common.utils.DateUtils;
import com.erp.common.xss.SQLFilter;
import com.erp.dto.reponse.sys.SysRoleRep;
import com.erp.dto.request.sys.SysRoleCreateReq;
import com.erp.dto.request.sys.SysRoleModifyReq;
import com.erp.entity.sys.SysRoleBean;
import com.erp.service.sys.SysRoleService;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 14:52:58
 */
@RestController
@RequestMapping(value = "/sys/sysrole", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "角色")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult create(SysRoleCreateReq data)
    {
			SysRoleBean entity=new SysRoleBean();

			sysRoleService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
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
    public ApiResult del(Long roleId)
    {
			sysRoleService.deleteByPrimaryKey(roleId);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
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