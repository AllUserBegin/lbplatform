package com.erp.service;
import com.erp.entity.SysRoleDeptBean;


import java.util.List;

public interface SysRoleDeptService extends IService<SysRoleDeptBean,Long> {

    void  BatchInsert(Long id, List<SysRoleDeptBean> deptList);
}
