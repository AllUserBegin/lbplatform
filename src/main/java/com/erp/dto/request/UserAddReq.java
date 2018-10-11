package com.erp.dto.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserAddReq {

    @NotBlank(message = "模块名称不能为空哟")
    @ApiModelProperty(value = "用户名",required = true)
    public String username;

    @NotBlank(message = "模块名称不能为空哟")
    @ApiModelProperty(value = "密码",required = true)
    public String password;
    @NotBlank(message = "模块名称不能为空哟")
    @ApiModelProperty(value = "邮箱" ,required = true)
    public String email;

    @ApiModelProperty(value = "出生日期")
    public String borndate;

   @ApiModelProperty(value = "年龄")
   public Integer age;
}


