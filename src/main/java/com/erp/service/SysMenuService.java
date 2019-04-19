package com.erp.service;
import com.erp.entity.SysMenuBean;


import java.util.List;

public interface SysMenuService extends IService<SysMenuBean,Long> {
    List<SysMenuBean> listAllByUserId(Long userId);

    List<SysMenuBean> MenuList() ;
}
