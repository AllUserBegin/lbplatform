package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 系统用户
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysUserCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long userId;


    
        //@NotBlank(message = "用户名不能为空")
        @ApiModelProperty(value = "用户名")//, required = true
        public String username;


    
        //@NotBlank(message = "密码不能为空")
        @ApiModelProperty(value = "密码")//, required = true
        public String password;


    
        //@NotBlank(message = "盐不能为空")
        @ApiModelProperty(value = "盐")//, required = true
        public String salt;


    
        //@NotBlank(message = "邮箱不能为空")
        @ApiModelProperty(value = "邮箱")//, required = true
        public String email;


    
        //@NotBlank(message = "手机号不能为空")
        @ApiModelProperty(value = "手机号")//, required = true
        public String mobile;


    
        //@NotBlank(message = "状态  0：禁用   1：正常不能为空")
        @ApiModelProperty(value = "状态  0：禁用   1：正常")//, required = true
        public Integer status;


    
        //@NotBlank(message = "部门ID不能为空")
        @ApiModelProperty(value = "部门ID")//, required = true
        public Long deptId;


    
        //@NotBlank(message = "创建时间不能为空")
        @ApiModelProperty(value = "创建时间")//, required = true
        public Date createTime;


    }
