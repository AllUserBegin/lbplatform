package com.erp.controller;
import com.erp.dto.request.UserModifyReq;
import com.github.pagehelper.PageInfo;
import com.erp.common.utils.ApiResult;
import com.erp.common.utils.DateUtils;
import com.erp.common.xss.SQLFilter;
import com.erp.dto.reponse.UserRep;
import com.erp.dto.request.UserAddReq;
import com.erp.entity.UsersBean;
import com.erp.service.UserService;
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

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "用户管理")
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult create(UserAddReq data)
    {
        UsersBean entity=new UsersBean();
        entity.setUsername(SQLFilter.sqlInject(data.username));
        entity.setBorndate(DateUtils.stringToDate(data.borndate,DateUtils.DATE_PATTERN));
        entity.setUserpwd(data.password);
        entity.setAge(data.age);
        entity.setUseremail(SQLFilter.sqlInject(data.email));
        userService.insert(entity);
        return ApiResult.Success("操作成功!");
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public  ApiResult modify(UserModifyReq data)
    {
        Example example = new Example(UsersBean.class);
        example.createCriteria().andEqualTo( "userid",100);
        UsersBean entity=userService.queryOneByExample(example);
        userService.updateByPrimaryKey(entity);
        return ApiResult.Success("操作成功!");
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ApiResult del(Integer id)
    {
        userService.deleteByPrimaryKey(id);
        return ApiResult.Success("删除成功!");
    }

    @ApiOperation(value = "获取单条")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public  ApiResult info(Integer id)
    {
        Example example = new Example(UsersBean.class);
        example.createCriteria().andEqualTo( "userid",100);
        UsersBean entity=  userService.queryOneByExample(example);
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
    public ApiResult<List<UserRep>> GetUserList(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "15") Integer size) {

        Example example = new Example(UsersBean.class);
        Example.Criteria criteria = example.createCriteria();

        PageInfo<UsersBean> pageInfo = userService.queryPageListByExample(example,page,size);

        List<UserRep> list = new ArrayList<>();
        for(UsersBean bean:pageInfo.getList())
        {
            UserRep item = new UserRep();
            BeanUtils.copyProperties(bean,item);
            list.add(item);
         }

        return ApiResult.Success(pageInfo.getTotal(),list);
    }





}
