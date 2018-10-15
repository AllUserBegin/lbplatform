package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 用户与角色对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysUserRoleCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "用户ID不能为空")
        @ApiModelProperty(value = "用户ID")//, required = true
        public Long userId;


    
        //@NotBlank(message = "角色ID不能为空")
        @ApiModelProperty(value = "角色ID")//, required = true
        public Long roleId;


    }
