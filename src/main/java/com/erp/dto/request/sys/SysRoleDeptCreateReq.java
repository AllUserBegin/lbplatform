package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 角色与部门对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysRoleDeptCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "角色ID不能为空")
        @ApiModelProperty(value = "角色ID")//, required = true
        public Long roleId;


    
        //@NotBlank(message = "部门ID不能为空")
        @ApiModelProperty(value = "部门ID")//, required = true
        public Long deptId;


    }
