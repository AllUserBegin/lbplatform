package com.erp.service.impl;
import com.erp.dao.SysMenuDao;
import com.erp.service.*;
import com.erp.entity.SysMenuBean;
import com.erp.service.BaseService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@ComponentScan({"com.erp.dao.SysMenuDao"})
@Service
public class SysMenuServiceImpl extends BaseService<SysMenuBean,Long> implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuMapper;


    public List<SysMenuBean> listAllByUserId(Long userId)
    {
        return sysMenuMapper.listAllByUserId(userId);
    }

    public List<SysMenuBean> MenuList()
    {
        return sysMenuMapper.MenuList();
    }

    public List<SysMenuBean> GetAll()
    {
        Example example = new Example(SysMenuBean.class);
        example.createCriteria();

        return queryByExample(example);
    }
}
