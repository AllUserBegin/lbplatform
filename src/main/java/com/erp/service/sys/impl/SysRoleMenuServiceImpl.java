package com.erp.service.sys.impl;
import com.erp.entity.sys.SysRoleMenuBean;
import com.erp.service.BaseService;
import com.erp.service.sys.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuServiceImpl extends BaseService<SysRoleMenuBean,Long> implements SysRoleMenuService {

    public void  BatchInsert(Long roleId, List<SysRoleMenuBean> list)
    {
        for (SysRoleMenuBean entity :list ) {
            entity.setRoleId(roleId);
            super.insert(entity);
        }
    }
}
