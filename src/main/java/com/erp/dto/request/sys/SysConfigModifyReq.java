package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 系统配置信息表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysConfigModifyReq extends  SysConfigCreateReq {

    @NotBlank(message = "id不能为空")
    @ApiModelProperty(value = "id",required = true)
    public Long id;

}
