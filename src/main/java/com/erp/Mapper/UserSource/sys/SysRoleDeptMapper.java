package com.erp.Mapper.UserSource.sys;

import com.erp.common.MyMapper;
import com.erp.entity.sys.SysRoleDeptBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * 角色与部门对应关系
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Component
@Mapper
public interface SysRoleDeptMapper extends MyMapper<SysRoleDeptBean> {
	
}
