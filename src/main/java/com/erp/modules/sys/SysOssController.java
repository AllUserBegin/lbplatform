package com.erp.modules.sys;

import com.erp.common.utils.ApiResult;
import com.erp.common.utils.DateUtils;
import com.erp.common.xss.SQLFilter;
import com.erp.dto.reponse.sys.SysOssRep;
import com.erp.dto.request.sys.SysOssCreateReq;
import com.erp.dto.request.sys.SysOssModifyReq;
import com.erp.entity.sys.SysOssBean;
import com.erp.service.sys.SysOssService;

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
 * 文件上传
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 14:52:58
 */
@RestController
@RequestMapping(value = "/sys/sysoss", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "文件上传")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;


    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult create(SysOssCreateReq data)
    {
			SysOssBean entity=new SysOssBean();

			sysOssService.insert(entity);
			return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public  ApiResult modify(SysOssModifyReq data)
    {
        Example example = new Example(SysOssBean.class);
        example.createCriteria().andEqualTo("id",data.id);

            SysOssBean entity=sysOssService.queryOneByExample(example);



			sysOssService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ApiResult del(Long id)
    {
			sysOssService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResult info(Long id)
    {
        Example example = new Example(SysOssBean.class);
        example.createCriteria().andEqualTo("id",id);
            SysOssBean entity= sysOssService.queryOneByExample(example);
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
    public ApiResult<List<SysOssRep>> GetSysOssList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(SysOssBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<SysOssBean> pageInfo = sysOssService.queryPageListByExample(example,page,size);

        List<SysOssRep> list = new ArrayList<>();
        for(SysOssBean bean:pageInfo.getList())
        {
				SysOssRep item = new SysOssRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
        }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }
}
