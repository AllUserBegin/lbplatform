package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.Column;

    

/**
 * 部门管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-19 14:48:57
 */
@Data
@Table(name = "sys_dept")
public class SysDeptBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        @Column(name = "dept_id")
        private Long deptId;
	        //上级部门ID，一级部门为0
        @Column(name = "parent_id")
        private Long parentId;
	        //部门名称
        @Column(name = "name")
        private String name;
	        //排序
        @Column(name = "order_num")
        private Integer orderNum;
	        //是否删除  -1：已删除  0：正常
        @Column(name = "del_flag")
        private Integer delFlag;
	
	        /**
         * 设置：
         */
        public void setDeptId(Long deptId) {
            this.deptId = deptId;
        }
        /**
         * 获取：
         */
        public Long getDeptId() {
            return deptId;
        }
	        /**
         * 设置：上级部门ID，一级部门为0
         */
        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }
        /**
         * 获取：上级部门ID，一级部门为0
         */
        public Long getParentId() {
            return parentId;
        }
	        /**
         * 设置：部门名称
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：部门名称
         */
        public String getName() {
            return name;
        }
	        /**
         * 设置：排序
         */
        public void setOrderNum(Integer orderNum) {
            this.orderNum = orderNum;
        }
        /**
         * 获取：排序
         */
        public Integer getOrderNum() {
            return orderNum;
        }
	        /**
         * 设置：是否删除  -1：已删除  0：正常
         */
        public void setDelFlag(Integer delFlag) {
            this.delFlag = delFlag;
        }
        /**
         * 获取：是否删除  -1：已删除  0：正常
         */
        public Integer getDelFlag() {
            return delFlag;
        }
	
    public static class ${
                    public static String deptId="deptId";
                    public static String parentId="parentId";
                    public static String name="name";
                    public static String orderNum="orderNum";
                    public static String delFlag="delFlag";
        
    }
}
