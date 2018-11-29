package com.erp.service.sys.impl;
import com.erp.entity.sys.SysRoleDeptBean;
import com.erp.service.BaseService;
import com.erp.service.sys.SysRoleDeptService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SysRoleDeptServiceImpl extends BaseService<SysRoleDeptBean,Long> implements SysRoleDeptService {

    /**
     * create by: lic
     * description:
     * create time: 下午 5:52 2018/11/29 0029
     * @return 
     */
    public void  BatchInsert(Long roleId,List<SysRoleDeptBean> list)
    {
        for (SysRoleDeptBean entity :list ) {
            entity.setRoleId(roleId);
            super.insert(entity);
        }
    }


  
 
}
