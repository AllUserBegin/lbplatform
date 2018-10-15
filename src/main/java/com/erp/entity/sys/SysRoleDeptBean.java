package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色与部门对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-15 09:41:58
 */
@Data
@Table(name = "sys_role_dept")
public class SysRoleDeptBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        private Long id;
	        //角色ID
        private Long roleId;
	        //部门ID
        private Long deptId;
	
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
         * 设置：部门ID
         */
        public void setDeptId(Long deptId) {
            this.deptId = deptId;
        }
        /**
         * 获取：部门ID
         */
        public Long getDeptId() {
            return deptId;
        }
	}
