package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 角色
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysRoleCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long roleId;


    
        //@NotBlank(message = "角色名称不能为空")
        @ApiModelProperty(value = "角色名称")//, required = true
        public String roleName;


    
        //@NotBlank(message = "备注不能为空")
        @ApiModelProperty(value = "备注")//, required = true
        public String remark;


    
        //@NotBlank(message = "部门ID不能为空")
        @ApiModelProperty(value = "部门ID")//, required = true
        public Long deptId;


    
        //@NotBlank(message = "创建时间不能为空")
        @ApiModelProperty(value = "创建时间")//, required = true
        public Date createTime;


    }
