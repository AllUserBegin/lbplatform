package com.erp.dto.request.sys;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;



/**
 * 部门管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysDeptModifyReq extends  SysDeptCreateReq {

    @NotBlank(message = "deptId不能为空")
    @ApiModelProperty(value = "deptId",required = true)
    public Long deptId;

}
