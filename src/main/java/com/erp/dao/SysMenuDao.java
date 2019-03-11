package com.erp.dao;

import com.erp.common.MyMapper;
import com.erp.entity.SysMenuBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单管理
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Resource
@Mapper
public interface SysMenuDao extends MyMapper<SysMenuBean> {


    @Select("SELECT  *   FROM    sys_menu   WHERE   menu_id IN ( SELECT menu_id  FROM   sys_role_menu WHERE  role_id IN ( SELECT role_id  FROM   sys_user_role  WHERE  user_id = ${user_id} ) ) ")
    List<SysMenuBean> listAllByUserId(@Param("user_id") Long user_id);


    List<SysMenuBean> MenuList();
}
