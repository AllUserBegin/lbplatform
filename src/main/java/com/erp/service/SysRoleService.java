package com.erp.service;
import com.erp.entity.SysRoleBean;
import com.erp.entity.SysRoleDeptBean;
import com.erp.entity.SysRoleMenuBean;


import java.util.List;

public interface SysRoleService extends IService<SysRoleBean,Long> {
    void  insert(SysRoleBean entiy, List<SysRoleDeptBean> deptList, List<SysRoleMenuBean> menuList);
}
