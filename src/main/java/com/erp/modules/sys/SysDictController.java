package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;

import com.erp.dto.reponse.sys.SysDictRep;
import com.erp.dto.request.sys.SysDictCreateReq;
import com.erp.dto.request.sys.SysDictModifyReq;
import com.erp.entity.sys.SysDictBean;
import com.erp.service.sys.SysDictService;

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
 * 数据字典表
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:31
 */
@RestController
@RequestMapping(value = "/sys/sysdict", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "数据字典表")
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysdict:create")
    public ApiResult create(SysDictCreateReq data)
    {
			SysDictBean entity=new SysDictBean();

			sysDictService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:sysdict:modify")
    public  ApiResult modify(SysDictModifyReq data)
    {
        Example example = new Example(SysDictBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysDictBean entity=sysDictService.queryOneByExample(example);



			sysDictService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysdict:del")
    public ApiResult del(Long id)
    {
			sysDictService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:sysdict:info")
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysDictBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysDictBean entity= sysDictService.queryOneByExample(example);
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
    @RequiresPermissions("sys:sysdict:list")
    public ApiResult<List<SysDictRep>> GetSysDictList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysDictBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysDictBean> pageInfo = sysDictService.queryPageListByExample(example,page,size);

        List<SysDictRep> list = new ArrayList<>();
        for(SysDictBean bean:pageInfo.getList())
        {
				SysDictRep item = new SysDictRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
