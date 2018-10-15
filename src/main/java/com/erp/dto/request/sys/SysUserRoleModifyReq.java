package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 用户与角色对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysUserRoleModifyReq extends  SysUserRoleCreateReq {

    @NotBlank(message = "id不能为空")
    @ApiModelProperty(value = "id",required = true)
    public Long id;

}
