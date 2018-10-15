package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 系统配置信息表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-15 09:41:58
 */
@Data
@Table(name = "sys_config")
public class SysConfigBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        private Long id;
	        //key
        private String paramKey;
	        //value
        private String paramValue;
	        //状态   0：隐藏   1：显示
        private Integer status;
	        //备注
        private String remark;
	
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
         * 设置：key
         */
        public void setParamKey(String paramKey) {
            this.paramKey = paramKey;
        }
        /**
         * 获取：key
         */
        public String getParamKey() {
            return paramKey;
        }
	        /**
         * 设置：value
         */
        public void setParamValue(String paramValue) {
            this.paramValue = paramValue;
        }
        /**
         * 获取：value
         */
        public String getParamValue() {
            return paramValue;
        }
	        /**
         * 设置：状态   0：隐藏   1：显示
         */
        public void setStatus(Integer status) {
            this.status = status;
        }
        /**
         * 获取：状态   0：隐藏   1：显示
         */
        public Integer getStatus() {
            return status;
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
	}
