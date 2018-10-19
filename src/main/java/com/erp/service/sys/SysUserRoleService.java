package com.erp.service.sys;

import com.erp.entity.sys.SysUserRoleBean;
import com.erp.service.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
public class SysUserRoleService extends BaseService<SysUserRoleBean,Long> {


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
