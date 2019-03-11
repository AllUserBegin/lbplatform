package com.erp.service.impl;
import com.erp.service.*;
import com.erp.entity.SysRoleMenuBean;
import com.erp.service.BaseService;

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
