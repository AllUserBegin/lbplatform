package com.erp.service;

import com.erp.entity.*;

import java.util.List;

public interface SysRoleMenuService extends IService<SysRoleMenuBean,Long> {

    void  BatchInsert(Long id, List<SysRoleMenuBean> deptList);
}
