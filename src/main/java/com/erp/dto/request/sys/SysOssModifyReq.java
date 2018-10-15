package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 文件上传
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysOssModifyReq extends  SysOssCreateReq {

    @NotBlank(message = "id不能为空")
    @ApiModelProperty(value = "id",required = true)
    public Long id;

}
