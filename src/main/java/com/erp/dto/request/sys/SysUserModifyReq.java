package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 系统用户
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysUserModifyReq extends  SysUserCreateReq {

    @NotBlank(message = "userId不能为空")
    @ApiModelProperty(value = "userId",required = true)
    public Long userId;

}
