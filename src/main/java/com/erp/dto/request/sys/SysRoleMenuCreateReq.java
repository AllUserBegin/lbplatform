package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 角色与菜单对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysRoleMenuCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "角色ID不能为空")
        @ApiModelProperty(value = "角色ID")//, required = true
        public Long roleId;


    
        //@NotBlank(message = "菜单ID不能为空")
        @ApiModelProperty(value = "菜单ID")//, required = true
        public Long menuId;


    }
