package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 数据字典表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysDictModifyReq extends  SysDictCreateReq {

    @NotBlank(message = "id不能为空")
    @ApiModelProperty(value = "id",required = true)
    public Long id;

}
