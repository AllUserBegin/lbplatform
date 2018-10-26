package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.Column;

    

/**
 * 角色
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-19 14:48:57
 */
@Data
@Table(name = "sys_role")
public class SysRoleBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        @Column(name = "role_id")
        private Long roleId;
	        //角色名称
        @Column(name = "role_name")
        private String roleName;
	        //备注
        @Column(name = "remark")
        private String remark;
	        //部门ID
        @Column(name = "dept_id")
        private Long deptId;
	        //创建时间
        @Column(name = "create_time")
        private Date createTime;
	
	        /**
         * 设置：
         */
        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }
        /**
         * 获取：
         */
        public Long getRoleId() {
            return roleId;
        }
	        /**
         * 设置：角色名称
         */
        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
        /**
         * 获取：角色名称
         */
        public String getRoleName() {
            return roleName;
        }
	        /**
         * 设置：备注
         */
        public void setRemark(String remark) {
            this.remark = remark;
        }
        /**
         * 获取：备注
         */
        public String getRemark() {
            return remark;
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
	        /**
         * 设置：创建时间
         */
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        /**
         * 获取：创建时间
         */
        public Date getCreateTime() {
            return createTime;
        }
	
    public static class ${
                    public static String roleId="roleId";
                    public static String roleName="roleName";
                    public static String remark="remark";
                    public static String deptId="deptId";
                    public static String createTime="createTime";
        
    }
}
