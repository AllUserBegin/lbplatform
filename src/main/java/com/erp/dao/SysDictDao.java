package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysDictBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 数据字典表
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Repository
@Mapper
public interface SysDictDao extends MyMapper<SysDictBean> {
	
}
