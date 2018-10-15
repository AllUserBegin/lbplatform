package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 系统配置信息表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysConfigCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "key不能为空")
        @ApiModelProperty(value = "key")//, required = true
        public String paramKey;


    
        //@NotBlank(message = "value不能为空")
        @ApiModelProperty(value = "value")//, required = true
        public String paramValue;


    
        //@NotBlank(message = "状态   0：隐藏   1：显示不能为空")
        @ApiModelProperty(value = "状态   0：隐藏   1：显示")//, required = true
        public Integer status;


    
        //@NotBlank(message = "备注不能为空")
        @ApiModelProperty(value = "备注")//, required = true
        public String remark;


    }
