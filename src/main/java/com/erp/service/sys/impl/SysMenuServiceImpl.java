package com.erp.service.sys;
import com.erp.Mapper.UserSource.sys.SysMenuMapper;
import com.erp.entity.sys.SysMenuBean;
import com.erp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl extends BaseService<SysMenuBean,Long> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;


    public List<SysMenuBean> listAllByUserId(Long userId)
    {
        return sysMenuMapper.listAllByUserId(userId);
    }



    public List<SysMenuBean> GetAll()
    {
        Example example = new Example(SysMenuBean.class);
        example.createCriteria();

        return queryByExample(example);
    }
}
