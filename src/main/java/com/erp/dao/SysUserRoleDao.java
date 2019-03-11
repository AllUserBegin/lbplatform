package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysUserRoleBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 用户与角色对应关系
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Resource
@Mapper
public interface SysUserRoleDao extends MyMapper<SysUserRoleBean> {
	
}
