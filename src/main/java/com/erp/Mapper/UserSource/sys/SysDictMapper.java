package com.erp.Mapper.UserSource.sys;

import com.erp.common.MyMapper;
import com.erp.entity.sys.SysDictBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * 数据字典表
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Component
@Mapper
public interface SysDictMapper extends MyMapper<SysDictBean> {
	
}
