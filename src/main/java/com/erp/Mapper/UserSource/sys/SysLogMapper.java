package com.erp.Mapper.UserSource.sys;

import com.erp.common.MyMapper;
import com.erp.entity.sys.SysLogBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * 系统日志
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Component
@Mapper
public interface SysLogMapper extends MyMapper<SysLogBean> {
	
}
