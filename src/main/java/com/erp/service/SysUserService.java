package com.erp.service;

import com.erp.entity.*;
import com.erp.service.IService;

import java.util.Set;

public interface SysUserService extends IService<SysUserBean,Long> {
    /**
     * create by: lic
     * description:
     * create time: 上午 10:27 2018/11/29 0029
     * @return 
     */
    SysUserBean findByName(String Username);
    /**
     * create by: lic
     * description:
     * create time: 上午 10:27 2018/11/29 0029
     * @return 
     */
    Set<String> findPermissions(Long userId, boolean fromCache);
}
