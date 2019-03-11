package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysLogBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * 系统日志
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Repository
@Mapper
public interface SysLogDao extends MyMapper<SysLogBean> {
	
}
