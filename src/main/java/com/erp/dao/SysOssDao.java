package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysOssBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 文件上传
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Resource
@Mapper
public interface SysOssDao extends MyMapper<SysOssBean> {
	
}
