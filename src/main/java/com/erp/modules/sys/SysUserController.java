package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;
import com.erp.common.utils.DateUtils;
import com.erp.common.xss.SQLFilter;
import com.erp.dto.reponse.sys.SysUserRep;
import com.erp.dto.request.sys.SysUserCreateReq;
import com.erp.dto.request.sys.SysUserModifyReq;
import com.erp.entity.sys.SysUserBean;
import com.erp.service.sys.SysUserService;

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
 * 系统用户
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 14:52:58
 */
@RestController
@RequestMapping(value = "/sys/sysuser", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "系统用户")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult create(SysUserCreateReq data)
    {
			SysUserBean entity=new SysUserBean();

			sysUserService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public  ApiResult modify(SysUserModifyReq data)
    {
        Example example = new Example(SysUserBean.class);
        example.createCriteria().andEqualTo("userId",data.userId);

            SysUserBean entity=sysUserService.queryOneByExample(example);



			sysUserService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ApiResult del(Long userId)
    {
			sysUserService.deleteByPrimaryKey(userId);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResult info(Long userId)
    {
        Example example = new Example(SysUserBean.class);
        example.createCriteria().andEqualTo("userId",userId);
            SysUserBean entity= sysUserService.queryOneByExample(example);
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
    public ApiResult<List<SysUserRep>> GetSysUserList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysUserBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysUserBean> pageInfo = sysUserService.queryPageListByExample(example,page,size);

        List<SysUserRep> list = new ArrayList<>();
        for(SysUserBean bean:pageInfo.getList())
        {
				SysUserRep item = new SysUserRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
