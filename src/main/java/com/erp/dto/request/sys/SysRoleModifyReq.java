package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 角色
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysRoleModifyReq extends  SysRoleCreateReq {

    @NotBlank(message = "roleId不能为空")
    @ApiModelProperty(value = "roleId",required = true)
    public Long roleId;

}
