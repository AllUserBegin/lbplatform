package com.erp.service.sys;
import com.erp.entity.sys.SysMenuBean;
import com.erp.service.IService;

import java.util.List;

public interface SysMenuService extends IService<SysMenuBean,Long> {
    List<SysMenuBean> listAllByUserId(Long userId);
}
