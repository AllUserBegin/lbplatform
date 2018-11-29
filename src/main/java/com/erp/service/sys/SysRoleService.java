package com.erp.service.sys;
import com.erp.entity.sys.SysRoleBean;
import com.erp.entity.sys.SysRoleDeptBean;
import com.erp.entity.sys.SysRoleMenuBean;
import com.erp.service.IService;

import java.util.List;

public interface SysRoleService extends IService<SysRoleBean,Long> {
    void  insert(SysRoleBean entiy, List<SysRoleDeptBean> deptList, List<SysRoleMenuBean> menuList);
}
