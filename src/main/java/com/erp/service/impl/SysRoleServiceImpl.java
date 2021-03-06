package com.erp.service.impl;
import com.erp.service.*;
import com.erp.entity.*;
import com.erp.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleServiceImpl extends BaseService<SysRoleBean,Long> implements SysRoleService {

    @Autowired
    private  SysRoleMenuService sysRoleMenuService;
    @Autowired
    private  SysRoleDeptService sysRoleDeptService;

    @Transactional(rollbackFor = Exception.class)
    public void  insert(SysRoleBean entiy,List<SysRoleDeptBean> deptList,List<SysRoleMenuBean> menuList)
    {
         this.insert(entiy);

        sysRoleDeptService.BatchInsert(entiy.getRoleId(),deptList);

        sysRoleMenuService.BatchInsert(entiy.getRoleId(),menuList);
    }
}
