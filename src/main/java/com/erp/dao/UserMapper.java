package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.UsersBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Resource
@Mapper
public interface UserMapper extends MyMapper<UsersBean>
{


}
