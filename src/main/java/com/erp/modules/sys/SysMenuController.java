package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;
import com.erp.common.utils.DateUtils;
import com.erp.common.xss.SQLFilter;
import com.erp.dto.reponse.sys.SysMenuRep;
import com.erp.dto.request.sys.SysMenuCreateReq;
import com.erp.dto.request.sys.SysMenuModifyReq;
import com.erp.entity.sys.SysMenuBean;
import com.erp.service.sys.SysMenuService;

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
 * 菜单管理
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 14:52:58
 */
@RestController
@RequestMapping(value = "/sys/sysmenu", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "菜单管理")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult create(SysMenuCreateReq data)
    {
			SysMenuBean entity=new SysMenuBean();

			sysMenuService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public  ApiResult modify(SysMenuModifyReq data)
    {
        Example example = new Example(SysMenuBean.class);
        example.createCriteria().andEqualTo("menuId",data.menuId);

            SysMenuBean entity=sysMenuService.queryOneByExample(example);



			sysMenuService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ApiResult del(Long menuId)
    {
			sysMenuService.deleteByPrimaryKey(menuId);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResult info(Long menuId)
    {
        Example example = new Example(SysMenuBean.class);
        example.createCriteria().andEqualTo("menuId",menuId);
            SysMenuBean entity= sysMenuService.queryOneByExample(example);
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
    public ApiResult<List<SysMenuRep>> GetSysMenuList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysMenuBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysMenuBean> pageInfo = sysMenuService.queryPageListByExample(example,page,size);

        List<SysMenuRep> list = new ArrayList<>();
        for(SysMenuBean bean:pageInfo.getList())
        {
				SysMenuRep item = new SysMenuRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
