package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.Column;

    

/**
 * 角色与菜单对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-19 14:48:57
 */
@Data
@Table(name = "sys_role_menu")
public class SysRoleMenuBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        @Column(name = "id")
        private Long id;
	        //角色ID
        @Column(name = "role_id")
        private Long roleId;
	        //菜单ID
        @Column(name = "menu_id")
        private Long menuId;
	
	        /**
         * 设置：
         */
        public void setId(Long id) {
            this.id = id;
        }
        /**
         * 获取：
         */
        public Long getId() {
            return id;
        }
	        /**
         * 设置：角色ID
         */
        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }
        /**
         * 获取：角色ID
         */
        public Long getRoleId() {
            return roleId;
        }
	        /**
         * 设置：菜单ID
         */
        public void setMenuId(Long menuId) {
            this.menuId = menuId;
        }
        /**
         * 获取：菜单ID
         */
        public Long getMenuId() {
            return menuId;
        }
	
    public static class ${
                    public static String id="id";
                    public static String roleId="roleId";
                    public static String menuId="menuId";
        
    }
}
