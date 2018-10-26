package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.Column;

    

/**
 * 用户与角色对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-19 14:48:57
 */
@Data
@Table(name = "sys_user_role")
public class SysUserRoleBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        @Column(name = "id")
        private Long id;
	        //用户ID
        @Column(name = "user_id")
        private Long userId;
	        //角色ID
        @Column(name = "role_id")
        private Long roleId;
	
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
         * 设置：用户ID
         */
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        /**
         * 获取：用户ID
         */
        public Long getUserId() {
            return userId;
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
	
    public static class ${
                    public static String id="id";
                    public static String userId="userId";
                    public static String roleId="roleId";
        
    }
}
