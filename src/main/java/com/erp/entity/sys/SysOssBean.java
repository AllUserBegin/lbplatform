package com.erp.entity.sys;

import java.util.Date;
import lombok.Data;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 文件上传
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-15 09:41:58
 */
@Data
@Table(name = "sys_oss")
public class SysOssBean implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        private Long id;
	        //URL地址
        private String url;
	        //创建时间
        private Date createDate;
	
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
         * 设置：URL地址
         */
        public void setUrl(String url) {
            this.url = url;
        }
        /**
         * 获取：URL地址
         */
        public String getUrl() {
            return url;
        }
	        /**
         * 设置：创建时间
         */
        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }
        /**
         * 获取：创建时间
         */
        public Date getCreateDate() {
            return createDate;
        }
	}
