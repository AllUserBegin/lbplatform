package com.erp.Mapper.UserSource.sys;

import com.erp.common.MyMapper;
import com.erp.entity.sys.SysMenuBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Component
@Mapper
public interface SysMenuMapper extends MyMapper<SysMenuBean> {


    @Select("SELECT  *   FROM    sys_menu   WHERE   menu_id IN ( SELECT menu_id  FROM   sys_role_menu WHERE  role_id IN ( SELECT role_id  FROM   sys_user_role  WHERE  user_id = ${user_id} ) ))  ")
    List<SysMenuBean> listAllByUserId(@Param("user_id") Long user_id);
}
