package com.erp.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public  class  UserModifyReq extends  UserAddReq
{
    @NotBlank(message = "ID不能为空哟")
    @ApiModelProperty(value = "ID",required = true)
    private Integer id;
}