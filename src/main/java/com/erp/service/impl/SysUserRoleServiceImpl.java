package com.erp.service.impl;
import com.erp.service.*;

import com.erp.entity.SysUserRoleBean;
import com.erp.service.BaseService;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
public class SysUserRoleServiceImpl extends BaseService<SysUserRoleBean,Long> implements SysUserRoleService {


    /*
      根据用户ID获取所有的权限
     */
    public List<SysUserRoleBean> SelectByUserId(Long userId)
    {
        Example example = new Example(SysUserRoleBean.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        return  queryByExample(example);
    }
}
