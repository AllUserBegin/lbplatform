package com.erp.service.sys;

import com.erp.entity.sys.SysOssBean;
import com.erp.entity.sys.SysRoleDeptBean;
import com.erp.service.IService;

import java.util.List;

public interface SysRoleDeptService extends IService<SysRoleDeptBean,Long> {

    void  BatchInsert(Long id, List<SysRoleDeptBean> deptList);
}
