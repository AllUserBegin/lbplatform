package com.erp.dto.reponse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRep extends  BaseRep {
    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "用户名")
    public String username;


    @ApiModelProperty(value = "密码")
    public String password;

    @ApiModelProperty(value = "邮箱" )
    public String email;

    @ApiModelProperty(value = "出生日期")
    public String borndate;

    @ApiModelProperty(value = "年龄")
    public Integer age;

    @ApiModelProperty(value = "是否删除")
    //是否删除 0未删 1 删除
    private Boolean isdel;
    @ApiModelProperty(value = "用户状态")
    //用户状态 0待审核  5审核不通过 10审核通过
    private Integer userstatus;

}
