package com.erp.service.sys;
import com.erp.entity.sys.SysMenuBean;
import com.erp.service.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuService extends BaseService<SysMenuBean,Long> {


    public  List<String> GetByUserId(Long userId)
    {
        List<String> list = new ArrayList();
        return list;
    }

    public List<SysMenuBean> GetAll()
    {
        Example example = new Example(SysMenuBean.class);
        example.createCriteria();

        return queryByExample(example);
    }
}
