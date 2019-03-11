package com.erp.entity;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.*;

    

/**
 * 系统配置信息表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-11-29 11:15:59
 */
@Data
@Table(name = "sys_config")
public class SysConfigBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
                @Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
          @Column(name = "id")
        private Long id;
	        //key
                  @Column(name = "param_key")
        private String paramKey;
	        //value
                  @Column(name = "param_value")
        private String paramValue;
	        //状态   0：隐藏   1：显示
                  @Column(name = "status")
        private Integer status;
	        //备注
                  @Column(name = "remark")
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
	
    public static class ${
                    public static String id="id";
                    public static String paramKey="paramKey";
                    public static String paramValue="paramValue";
                    public static String status="status";
                    public static String remark="remark";
        
    }
}
