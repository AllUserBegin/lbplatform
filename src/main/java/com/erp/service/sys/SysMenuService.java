package com.erp.service.sys;
import com.erp.Mapper.UserSource.sys.SysMenuMapper;
import com.erp.entity.sys.SysMenuBean;
import com.erp.service.BaseService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuService extends BaseService<SysMenuBean,Long> {
    @Autowired
    private SysMenuMapper sysMenuMapper;


    public  List<SysMenuBean> listAllByUserId(Long userId)
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
