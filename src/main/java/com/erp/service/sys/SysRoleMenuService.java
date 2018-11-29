package com.erp.service.sys;

import com.erp.entity.sys.*;
import com.erp.service.IService;

import java.util.List;

public interface SysRoleMenuService extends IService<SysRoleMenuBean,Long> {

    void  BatchInsert(Long id, List<SysRoleMenuBean> deptList);
}
