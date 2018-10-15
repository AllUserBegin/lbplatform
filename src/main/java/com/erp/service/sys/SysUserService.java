package com.erp.service.sys;
import com.erp.entity.sys.SysUserBean;
import com.erp.service.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class SysUserService extends BaseService<SysUserBean,Long> {

    public SysUserBean GetById(Example example) {
        return super.queryOneByExample(example);
    }


    public SysUserBean GetInfo(SysUserBean  entity) {
        SysUserBean model = new SysUserBean();
        return model;
    }
}
