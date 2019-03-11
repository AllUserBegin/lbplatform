package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysDeptBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 部门管理
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Repository
@Mapper
public interface SysDeptDao extends MyMapper<SysDeptBean> {
	
}
