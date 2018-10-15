package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 菜单管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysMenuModifyReq extends  SysMenuCreateReq {

    @NotBlank(message = "menuId不能为空")
    @ApiModelProperty(value = "menuId",required = true)
    public Long menuId;

}
