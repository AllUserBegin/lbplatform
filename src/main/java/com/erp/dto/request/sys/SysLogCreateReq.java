package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 系统日志
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysLogCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "用户名不能为空")
        @ApiModelProperty(value = "用户名")//, required = true
        public String username;


    
        //@NotBlank(message = "用户操作不能为空")
        @ApiModelProperty(value = "用户操作")//, required = true
        public String operation;


    
        //@NotBlank(message = "请求方法不能为空")
        @ApiModelProperty(value = "请求方法")//, required = true
        public String method;


    
        //@NotBlank(message = "请求参数不能为空")
        @ApiModelProperty(value = "请求参数")//, required = true
        public String params;


    
        //@NotBlank(message = "执行时长(毫秒)不能为空")
        @ApiModelProperty(value = "执行时长(毫秒)")//, required = true
        public Long time;


    
        //@NotBlank(message = "IP地址不能为空")
        @ApiModelProperty(value = "IP地址")//, required = true
        public String ip;


    
        //@NotBlank(message = "创建时间不能为空")
        @ApiModelProperty(value = "创建时间")//, required = true
        public Date createDate;


    }
