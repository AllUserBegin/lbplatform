package com.erp.Mapper.UserSource;

import com.erp.common.MyMapper;
import com.erp.entity.UsersBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends MyMapper<UsersBean>
{


}
