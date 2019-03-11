package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysUserBean;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/**
 * 系统用户
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Resource
@Mapper
public interface SysUserDao extends MyMapper<SysUserBean> {
	
}
