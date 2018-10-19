package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;
import com.erp.dto.reponse.sys.SysLogRep;
import com.erp.dto.request.sys.SysLogCreateReq;
import com.erp.dto.request.sys.SysLogModifyReq;
import com.erp.entity.sys.SysLogBean;
import com.erp.service.sys.SysLogService;

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
 * 系统日志
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-18 16:01:31
 */
@RestController
@RequestMapping(value = "/sys/syslog", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "系统日志")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @RequiresPermissions("sys:syslog:create")
    public ApiResult create(SysLogCreateReq data)
    {
			SysLogBean entity=new SysLogBean();

			sysLogService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @RequiresPermissions("sys:syslog:modify")
    public  ApiResult modify(SysLogModifyReq data)
    {
        Example example = new Example(SysLogBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysLogBean entity=sysLogService.queryOneByExample(example);



			sysLogService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @RequiresPermissions("sys:syslog:del")
    public ApiResult del(Long id)
    {
			sysLogService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @RequiresPermissions("sys:syslog:info")
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysLogBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysLogBean entity= sysLogService.queryOneByExample(example);
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
    @RequiresPermissions("sys:syslog:list")
    public ApiResult<List<SysLogRep>> GetSysLogList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysLogBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysLogBean> pageInfo = sysLogService.queryPageListByExample(example,page,size);

        List<SysLogRep> list = new ArrayList<>();
        for(SysLogBean bean:pageInfo.getList())
        {
				SysLogRep item = new SysLogRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
